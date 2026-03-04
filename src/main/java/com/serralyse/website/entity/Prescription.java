package com.serralyse.website.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "prescriptions", indexes = {
        @Index(name = "idx_prescription_analysis_id", columnList = "analysis_id"),
        @Index(name = "idx_prescription_created_at", columnList = "createdAt"),
        @Index(name = "idx_prescription_status", columnList = "productionStatus")
})
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "analysis_id",nullable = false)
    @JsonIgnore
    private SkinAnalysis skinAnalysis;

    @Column(columnDefinition = "TEXT")
    private String specialInstructions;

    private ProductionStatus productionStatus;

    @ManyToOne
    @JoinColumn(name = "assigned_pod_id")
    private MicroPod assignedPod;

    private String pifDocumentPath;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    private List<PrescriptionItem> items;

    @PrePersist
    protected void onCreate(){
        createdAt = LocalDateTime.now();
        productionStatus = ProductionStatus.PENDING;
    }

}
