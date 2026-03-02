package com.serralyse.website.dto;

import com.serralyse.website.entity.SkinType;
import lombok.Data;

import java.util.List;

@Data
public class SkinAnalysisRequest {
    private SkinType skinType;
    private List<String> concerns;
    private Integer age;
}
