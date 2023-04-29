package com.md.estate.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBusinessRequest implements Serializable {
    private String businessName;
    private String contactPerson;
    private String address;
    private String phone;
    private String fax;
}
