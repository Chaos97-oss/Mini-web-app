package com.example.onboarding_web_app.service;



import org.springframework.stereotype.Service;

import com.example.dto.AssetDTO;
import com.example.dto.AssetPageData;
import com.example.onboarding_web_app.modal.Asset;

import java.util.List;

@Service
public interface AssetService {
    List<Asset> getAllAssets();
    void loadAssetsFromCSV();
    AssetPageData getAssetPageData();
    void saveAsset(AssetDTO assetDTO);
}