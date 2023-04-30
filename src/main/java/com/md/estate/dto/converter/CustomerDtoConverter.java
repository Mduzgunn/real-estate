package com.md.estate.dto.converter;

import com.md.estate.dto.CustomerDto;
import com.md.estate.dto.EstateDto;
import com.md.estate.model.Customer;
import com.md.estate.model.Estate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    public List<CustomerDto> convertToCustomerDtoList(List<Customer> allCustomers) {
        return allCustomers
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    public CustomerDto convert(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getHomePhoneNumber(),
                from.getMobilePhoneNumber(),
                from.getEmailAddress(),
                from.getBusiness(),
                getEstateList(from.getEstates())
        );
    }

        public List<EstateDto> getEstateList(List<Estate> estateList){
        return estateList.stream().map(
                c -> new EstateDto(
                        c.getId(),
                        c.getEstateType(),
                        c.getSquareMeters(),
                        c.getRoomNumber(),
                        c.getFloorNumber(),
                        c.getHeatingSystem()
                )
        ).collect(Collectors.toList());
    }
}
