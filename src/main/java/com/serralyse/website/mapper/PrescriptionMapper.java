package com.serralyse.website.mapper;

import com.serralyse.website.dto.PrescriptionItemResponse;
import com.serralyse.website.dto.PrescriptionResponse;
import com.serralyse.website.entity.Prescription;
import com.serralyse.website.entity.PrescriptionItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrescriptionMapper {
    public PrescriptionResponse toResponse(Prescription prescription) {
        PrescriptionResponse response = new PrescriptionResponse();
        response.setId(prescription.getId());
        response.setCreatedAt(prescription.getCreatedAt());
        response.setSpecialInstructions(prescription.getSpecialInstructions());
        if(prescription.getAssignedPod() != null) {
            response.setAssignedPodLocation(prescription.getAssignedPod().getLocation());
        }
        List<PrescriptionItemResponse> itemResponses = prescription.getItems()
                .stream()
                .map(this::toItemResponse)
                .collect(Collectors.toList());
        response.setItems(itemResponses);

        return response;
    }

    private PrescriptionItemResponse toItemResponse(PrescriptionItem item){
        return new PrescriptionItemResponse(
                item.getId(),
                item.getRawMaterial().getName(),
                item.getRawMaterial().getInciName(),
                item.getRatio()
        );
    }

}
