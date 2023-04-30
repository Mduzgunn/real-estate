package com.md.estate.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "business_name")
    private String businessName;

    private String address;

    private String phone;

    private String fax;

    @OneToOne(mappedBy = "business", cascade = CascadeType.ALL)
    private Customer customer;

    public Business(String businessName, String address, String phone, String fax) {
        this.businessName = businessName;
        this.address = address;
        this.phone = phone;
        this.fax = fax;
    }
}
