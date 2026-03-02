package com.serralyse.website.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "micro_pods")
@Data
public class MicroPod {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String location;

    @Enumerated(EnumType.STRING)
    private PodStatus status;

    private LocalDateTime lastCleaningDate;



}
