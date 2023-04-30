package com.md.estate.dto.request;

import com.md.estate.dto.CustomerDto;
import lombok.Data;

import java.util.List;

@Data
public class UpdateBusinessRequest {
    private String address;
    private String phone;
    private String fax;
    private List<CustomerDto> customerList;
}
