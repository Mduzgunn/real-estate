package com.md.estate.dto;

import com.md.estate.model.EstateType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EstateDto {

    private Long id;

    private EstateType estateType;

    private double squareMeters;

    private int roomNumber;

    private int floorNumber;

    private String heatingSystem;

    private Long customer;

    public EstateDto(Long id, EstateType estateType, double squareMeters, int roomNumber,
                     int floorNumber, String heatingSystem) {
        this.id = id;
        this.estateType = estateType;
        this.squareMeters = squareMeters;
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.heatingSystem = heatingSystem;
    }



    public EstateDto(Long id, EstateType estateType, double squareMeters,
                     int roomNumber, int floorNumber, String heatingSystem, Long customer) {
        this.id = id;
        this.estateType = estateType;
        this.squareMeters = squareMeters;
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.heatingSystem = heatingSystem;
        this.customer = customer;
    }
}
