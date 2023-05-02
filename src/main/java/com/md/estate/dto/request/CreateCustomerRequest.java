package com.md.estate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private String name;
    private String surname;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String emailAddress;
}
