package com.example.dto;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AssetDTO {

    private String category;
    private String assetName;
    private BigDecimal amount;
    private Integer duration;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate purchasedDate;
    private String branch;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastDepreciationDate;
    private String status;
    private Integer usefulLife;
    private String name;
    private String location;

    // Getters and Setters
    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getAssetName() { return assetName; }

    public void setAssetName(String assetName) { this.assetName = assetName; }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public Integer getDuration() { return duration; }

    public void setDuration(Integer duration) { this.duration = duration; }

    public LocalDate getPurchasedDate() { return purchasedDate; }

    public void setPurchasedDate(LocalDate purchasedDate) { this.purchasedDate = purchasedDate; }

    public String getBranch() { return branch; }

    public void setBranch(String branch) { this.branch = branch; }

    public LocalDate getLastDepreciationDate() { return lastDepreciationDate; }

    public void setLastDepreciationDate(LocalDate lastDepreciationDate) {
        this.lastDepreciationDate = lastDepreciationDate;
    }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
    
    public Integer getUsefulLife() {
        return usefulLife;
    }

    
    public void setUsefulLife(Integer usefulLife) {
        this.usefulLife = usefulLife;
    }


    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

}