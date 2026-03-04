package com.serralyse.website.controller;

import com.serralyse.website.dto.PrescriptionResponse;
import com.serralyse.website.dto.SkinAnalysisRequest;
import com.serralyse.website.entity.Prescription;
import com.serralyse.website.entity.User;
import com.serralyse.website.mapper.PrescriptionMapper;
import com.serralyse.website.service.SkinAnalysisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skin-analyses")
@RequiredArgsConstructor
public class AnalysisController {
    private final SkinAnalysisService analysisService;
    private final PrescriptionMapper prescriptionMapper;

    @PostMapping
    public ResponseEntity<PrescriptionResponse> createSkinAnalysis(
            @AuthenticationPrincipal User user,
            @Valid @RequestBody SkinAnalysisRequest request
    ) {
        Prescription prescription = analysisService.createAnalysisAndPrescribe(user.getId(), request);
        PrescriptionResponse response = prescriptionMapper.toResponse(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
