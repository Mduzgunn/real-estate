package com.md.estate.dto.converter;

import com.md.estate.dto.BusinessDto;
import com.md.estate.model.Business;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class BusinessDtoConverter {
    public List<BusinessDto> convertToBusinessDtoList(List<Business> businessList) {
        return businessList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public BusinessDto convert(Business from) {
        return new BusinessDto(
                from.getId(),
                from.getBusinessName(),
                from.getAddress(),
                from.getPhone(),
                from.getFax(),
                from.getCustomer()
        );
    }
}
