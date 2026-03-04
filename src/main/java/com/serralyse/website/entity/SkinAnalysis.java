package com.serralyse.website.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "skin_analyses", indexes = {
        @Index(name = "idx_skin_analysis_user_id", columnList = "user_id"),
        @Index(name = "idx_skin_analysis_date", columnList = "analysisDate")
})
@Data
public class SkinAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(name = "skin_type", nullable = false)
    private SkinType skinType;
    @Column(columnDefinition = "TEXT")
    private String concerns;
    private Integer age;
    private LocalDateTime analysisDate;
    private String photoPath;

    @PrePersist
    protected void onCreate(){
        analysisDate = LocalDateTime.now();
    }
}
