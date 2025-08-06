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

    // @Override
    // public void loadAssetsFromCSV() {
    //     System.out.println("CSV loading not yet implemented");
    // }

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
                    continue; // skip header
                }
                if (line.length < 10) {
        System.err.println("Skipping row with insufficient columns: " + Arrays.toString(line));
        continue;
        }

                Asset asset = new Asset();
                asset.setAssetName(line[0]);
                asset.setCategoryId(line[1]);
                asset.setAssetAmount(new BigDecimal(line[2]));
                asset.setDurationMonths(line[3]);

                // 🛠 Handle optional or blank dates safely
                if (line[4] != null && !line[4].trim().isEmpty()) {
                    asset.setPurchasedDate(LocalDate.parse(line[4].trim(), csvFormatter));
                }

                asset.setBranch(line[5]);

                if (line[6] != null && !line[6].trim().isEmpty()) {
                    asset.setLastDepDate(LocalDate.parse(line[6].trim(), csvFormatter));
                }

                asset.setStatus(line[7]);
                asset.setName(line[8]);
                asset.setLocation(line[9]);

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
                dto.setPurchasedDate(asset.getPurchasedDate().format(displayFormatter)); // e.g. 11 February 2023
            }

            dto.setBranch(asset.getBranch());

            if (asset.getLastDepDate() != null) {
                dto.setLastDepreciationDate(asset.getLastDepDate().format(displayFormatter));
            }

            dto.setStatus(asset.getStatus());
            return dto;
        }).collect(Collectors.toList());

        // ✅ Initialize and populate AssetPageData
        AssetPageData data = new AssetPageData();
        data.setName("Bitwire Asset Registry");

        if (!assets.isEmpty() && assets.get(0).getLocation() != null) {
            data.setLocation(assets.get(0).getLocation());
        } else {
            data.setLocation("Lagos, Nigeria");
        }

        data.setAssets(assetDTOs);
        return data;
    }

}
