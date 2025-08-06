package com.example.dto;

import java.util.List;

public class AssetPageData {

    private String name;
    private String location;
    private List<AssetDTO> assets;

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<AssetDTO> getAssets() {
        return assets;
    }

    public void setAssets(List<AssetDTO> assets) {
        this.assets = assets;
    }
}