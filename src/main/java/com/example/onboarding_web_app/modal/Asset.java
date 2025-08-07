package com.example.onboarding_web_app.modal;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "assets")
@Data
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryId;
    private String assetName;
    private BigDecimal assetAmount;
    private Integer durationMonths;
    private LocalDate purchasedDate;
    private String branch;
    private LocalDate lastDepDate;
    private String status;
    private String name;
    private String location;
    private Integer usefulLife;

//     public Integer getDurationMonths() {
//     return durationMonths;
// }

// public void setDurationMonths(Integer durationMonths) {
//     this.durationMonths = durationMonths;
// }

// public Integer getUsefulLife() {
//     return usefulLife;
// }

// public void setUsefulLife(Integer usefulLife) {
//     this.usefulLife = usefulLife;
// }

}

