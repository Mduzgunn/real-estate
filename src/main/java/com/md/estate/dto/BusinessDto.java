package com.md.estate.dto;

import com.md.estate.model.Customer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BusinessDto {

    private Long id;

    private String businessName;

    private String address;

    private String phone;

    private String fax;

    @OneToOne(mappedBy = "business", cascade = CascadeType.ALL)
    private Customer customer;

}
