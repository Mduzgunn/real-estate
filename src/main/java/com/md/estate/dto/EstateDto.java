package com.md.estate.dto;

import com.md.estate.model.EstateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EstateDto {

    private Long id;

    private EstateType estateType;

    private double squareMeters;

    private int roomNumber;

    private int floorNumber;

    private String heatingSystem;

    private Long customerId;
}
