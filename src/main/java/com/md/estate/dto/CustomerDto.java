package com.md.estate.dto;

import com.md.estate.model.Business;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
public class CustomerDto {

    private Long id;

    private String name;

    private String surname;

    private String homePhoneNumber;

    private String mobilePhoneNumber;

    private String emailAddress;

    @OneToOne
    @JoinColumn(name = "business_id")
    private Business business;

    @OneToMany(mappedBy = "customerInfo", cascade = CascadeType.ALL)
    private List<EstateDto> estate;

}
