package com.md.estate.dto.converter;

import com.md.estate.dto.BusinessDto;
import com.md.estate.dto.CustomerDto;
import com.md.estate.dto.EstateDto;
import com.md.estate.model.Estate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EstateDtoConverter {

    public EstateDto convert(Estate from) {
        return new EstateDto(
                from.getId(),
                from.getEstateType(),
                from.getSquareMeters(),
                from.getRoomNumber(),
                from.getFloorNumber(),
                from.getHeatingSystem(),
                from.getCustomer().getId()
        );
    }

    public List<EstateDto> convertToEstateDtoList(List<Estate> allEstates) {
        return allEstates
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

}
