package com.md.estate.dto.request;

import com.md.estate.model.EstateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstateSearchRequest {
    private EstateType estateType;
    private Double squareMeters;
    private Integer roomNumber;
    private Integer floorNumber;
    private String heatingSystem;
}
