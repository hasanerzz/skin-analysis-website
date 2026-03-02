package com.serralyse.website.controller;

import com.serralyse.website.dto.PrescriptionResponse;
import com.serralyse.website.dto.SkinAnalysisRequest;
import com.serralyse.website.entity.Prescription;
import com.serralyse.website.mapper.PrescriptionMapper;
import com.serralyse.website.service.SkinAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/analysis")
@RequiredArgsConstructor
public class AnalysisController {
    private final SkinAnalysisService analysisService;
    private final PrescriptionMapper prescriptionMapper;

    @PostMapping("/user/{userId}")
    public ResponseEntity<PrescriptionResponse> createAnalysis(@PathVariable UUID userId, @RequestBody SkinAnalysisRequest request){
        Prescription prescription = analysisService.createAnalysisAndPrescribe(userId, request);
        PrescriptionResponse response = prescriptionMapper.toResponse(prescription);
        return ResponseEntity.ok(response);
    }


}
