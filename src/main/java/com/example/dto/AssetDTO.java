package com.example.dto;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AssetDTO {

    private String category;
    private String assetName;
    private BigDecimal amount;
    private String duration;
    private String purchasedDate;
    private String branch;
    private String lastDepreciationDate;
    private String status;

    // Getters and Setters
    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getAssetName() { return assetName; }

    public void setAssetName(String assetName) { this.assetName = assetName; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDuration() { return duration; }

    public void setDuration(String duration) { this.duration = duration; }

    public String getPurchasedDate() { return purchasedDate; }

    public void setPurchasedDate(String purchasedDate) { this.purchasedDate = purchasedDate; }

    public String getBranch() { return branch; }

    public void setBranch(String branch) { this.branch = branch; }

    public String getLastDepreciationDate() { return lastDepreciationDate; }

    public void setLastDepreciationDate(String lastDepreciationDate) {
        this.lastDepreciationDate = lastDepreciationDate;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}