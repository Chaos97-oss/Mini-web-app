package com.example.onboarding_web_app.service.impl;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.dto.AssetDTO;
import com.example.dto.AssetPageData;
import com.example.onboarding_web_app.modal.*;
import com.example.onboarding_web_app.repository.AssetRepository;
import com.example.onboarding_web_app.service.AssetService;
import com.opencsv.CSVReader;

import jakarta.annotation.PostConstruct;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    @PostConstruct
    public void init() {
        loadAssetsFromCSV();
    }

    @Override
    public void loadAssetsFromCSV() {
        try {
            ClassPathResource resource = new ClassPathResource("data.csv");
            CSVReader reader = new CSVReader(new InputStreamReader(resource.getInputStream()));
            String[] line;
            boolean isFirstLine = true;
            List<Asset> assets = new ArrayList<>();

            DateTimeFormatter csvFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            while ((line = reader.readNext()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; 
                }
                if (line.length < 8) {
                    System.err.println("Skipping row with insufficient columns: " + Arrays.toString(line));
                    continue;
                }

                Asset asset = new Asset();
                asset.setCategoryId(line[0]);
                asset.setAssetName(line[1]);
                asset.setAssetAmount(new BigDecimal(line[2]));
                asset.setDurationMonths(Integer.parseInt(line[3]));
                if (line[4] != null && !line[4].trim().isEmpty()) {
                    asset.setPurchasedDate(LocalDate.parse(line[4].trim(), csvFormatter));
                }

                asset.setBranch(line[5]);

                if (line[6] != null && !line[6].trim().isEmpty()) {
                    asset.setLastDepDate(LocalDate.parse(line[6].trim(), csvFormatter));
                }

                asset.setStatus(line[7]);

                //
                asset.setName("Udegbue Paul");
                asset.setLocation("Lagos, Nigeria");

                assets.add(asset);
            }

            assetRepository.saveAll(assets);
            System.out.println("Assets loaded from CSV successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public AssetPageData getAssetPageData() {
        List<Asset> assets = assetRepository.findAll();
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");

        List<AssetDTO> assetDTOs = assets.stream().map(asset -> {
            AssetDTO dto = new AssetDTO();
            dto.setAssetName(asset.getAssetName());
            dto.setCategory(asset.getCategoryId());
            dto.setAmount(asset.getAssetAmount());
            dto.setDuration(asset.getDurationMonths());

            if (asset.getPurchasedDate() != null) {
                dto.setPurchasedDate(asset.getPurchasedDate()); 
            }

            dto.setBranch(asset.getBranch());

            if (asset.getLastDepDate() != null) {
                dto.setLastDepreciationDate(asset.getLastDepDate()); 
            }

            dto.setStatus(asset.getStatus());
            return dto;
        }).collect(Collectors.toList());

        // ✅ Initialize and populate AssetPageData
        AssetPageData data = new AssetPageData();
        data.setName("Udegbue Paul");

        if (!assets.isEmpty() && assets.get(0).getLocation() != null) {
            data.setLocation(assets.get(0).getLocation());
        } else {
            data.setLocation("Lagos, Nigeria");
        }

        data.setAssets(assetDTOs);
        return data;
    }


    @Override
    public void saveAsset(AssetDTO dto) {
        Asset asset = new Asset();

        asset.setName(dto.getName());
        asset.setLocation(dto.getLocation());
        asset.setAssetName(dto.getAssetName());
        asset.setCategoryId(dto.getCategory());
        asset.setAssetAmount(dto.getAmount());
        asset.setDurationMonths(dto.getDuration());
        asset.setUsefulLife(dto.getUsefulLife());
        asset.setBranch(dto.getBranch());
        asset.setStatus("Active");

        if (dto.getPurchasedDate() != null) {
            asset.setPurchasedDate(dto.getPurchasedDate());
        }

        if (dto.getLastDepreciationDate() != null) {
            asset.setLastDepDate(dto.getLastDepreciationDate());
        }

        assetRepository.save(asset);
    }

}
