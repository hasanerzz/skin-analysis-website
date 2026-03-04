package com.serralyse.website.dto;

import com.serralyse.website.entity.SkinType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SkinAnalysisRequest {
    @NotNull(message = "Skin type is required")
    private SkinType skinType;

    private List<String> concerns;

    @NotNull(message = "Age is required")
    @Min(value = 13, message = "Age must be at least 13")
    @Max(value = 120, message = "Age must be less than 120")
    private Integer age;
}
