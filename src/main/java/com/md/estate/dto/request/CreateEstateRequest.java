package com.md.estate.dto.request;

import com.md.estate.model.EstateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstateRequest implements Serializable {
    private EstateType estateType;
    private double squareMeters;
    private int roomNumber;
    private int floorNumber;
    private String heatingSystem;
    private Long customerId;
}
