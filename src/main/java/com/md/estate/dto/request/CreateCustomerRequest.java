package com.md.estate.dto.request;

import com.md.estate.dto.EstateDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest implements Serializable {
    private String name;
    private String surname;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String emailAddress;
    private Long businessId;
    private List<EstateDto> estateList;
}
