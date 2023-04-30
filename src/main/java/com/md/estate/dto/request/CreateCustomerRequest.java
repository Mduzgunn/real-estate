package com.md.estate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest implements Serializable {
    private String name;
    private String surname;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String emailAddress;
}
