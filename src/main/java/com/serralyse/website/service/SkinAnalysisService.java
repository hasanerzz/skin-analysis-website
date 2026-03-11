package com.serralyse.website.service;

import com.serralyse.website.dto.SkinAnalysisRequest;
import com.serralyse.website.entity.*;
import com.serralyse.website.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SkinAnalysisService {
    private final SkinAnalysisRepository skinAnalysisRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final RawMaterialRepository rawMaterialRepository;
    private final UserRepository userRepository;

    @Transactional
    public Prescription createAnalysisAndPrescribe(UUID userId, SkinAnalysisRequest request){

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User has not found"));
        SkinAnalysis analysis = new SkinAnalysis();
        analysis.setUser(user);
        analysis.setSkinType(request.getSkinType());
        analysis.setAge(request.getAge());
        analysis.setPhotoPath("/mock/images/default.jpg");
        skinAnalysisRepository.save(analysis);

        Prescription prescription = new Prescription();
        prescription.setSkinAnalysis(analysis);
        prescription.setCreatedAt(LocalDateTime.now());
        prescription.setItems(new ArrayList<>());

        if(request.getSkinType() == SkinType.OILY){
            addProductToPrescription(prescription, "Salicylic", 2.0);
        } else if(request.getSkinType() == SkinType.DRY){
            addProductToPrescription(prescription, "Hyaluronic", 3.0);
        }
        addProductToPrescription(prescription, "Titanium", 1.0);

        return prescriptionRepository.save(prescription);
    }

    @Cacheable(value = "rawMaterials", key = "#productName")
    private void addProductToPrescription(Prescription prescription, String productName, Double ratio){
        rawMaterialRepository.findByNameContainingIgnoreCase(productName).ifPresent(product -> {
            PrescriptionItem item = new PrescriptionItem();
            item.setPrescription(prescription);
            item.setRawMaterial(product);
            item.setRatio(ratio);
            prescription.getItems().add(item);
        });
    }
}
