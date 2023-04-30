package com.md.estate.dto.request;

import com.md.estate.model.EstateType;
import lombok.Data;

import java.io.Serializable;

@Data
public class CreateEstateRequest implements Serializable {
    private EstateType estateType;
    private double squareMeters;
    private int roomNumber;
    private int floorNumber;
    private String heatingSystem;
    private Long customerId;
}
