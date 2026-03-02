package com.serralyse.website.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "raw_materials")
@Data
public class RawMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String inciName;

    private String description;
    private Double purityPercentage;
    private String batchCode;
    private Integer stockLevelMl;
    private Double unitPriceMl;


}
