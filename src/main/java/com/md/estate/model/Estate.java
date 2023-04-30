package com.md.estate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estate_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "estate_type")
    private EstateType estateType;

    @Column(name = "square_meters")
    private double squareMeters;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "floor_number")
    private int floorNumber;

    @Column(name = "heating_system")
    private String heatingSystem;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    public Estate(EstateType estateType, double squareMeters, int roomNumber, int floorNumber,
                  String heatingSystem, Customer customer) {
        this.estateType = estateType;
        this.squareMeters = squareMeters;
        this.roomNumber = roomNumber;
        this.floorNumber = floorNumber;
        this.heatingSystem = heatingSystem;
        this.customer = customer;
    }

    public Estate(Long id, String heatingSystem, Customer customer) {
        this.id = id;
        this.heatingSystem = heatingSystem;
        this.customer = customer;
    }
}
