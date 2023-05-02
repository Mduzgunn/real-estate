package com.md.estate.service;

import com.md.estate.dto.EstateDto;
import com.md.estate.dto.converter.EstateDtoConverter;
import com.md.estate.dto.request.CreateEstateRequest;
import com.md.estate.dto.request.EstateSearchRequest;
import com.md.estate.dto.request.UpdateEstateRequest;
import com.md.estate.exception.EstateNotFoundException;
import com.md.estate.model.Customer;
import com.md.estate.model.Estate;
import com.md.estate.model.EstateType;
import com.md.estate.repository.EstateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateService {
    private final EstateRepository estateRepository;
    private final EstateDtoConverter estateDtoConverter;
    private final CustomerService customerService;

    public EstateService(EstateRepository estateRepository,
                         EstateDtoConverter estateDtoConverter,
                         CustomerService customerService) {
        this.estateRepository = estateRepository;
        this.estateDtoConverter = estateDtoConverter;
        this.customerService = customerService;
    }

    protected Estate findEstateById(Long id) {
        return estateRepository
                .findById(id)
                .orElseThrow(() -> new EstateNotFoundException("Estate not found " + id));
    }

    public EstateDto getEstateById(Long id) {
        return estateDtoConverter.convert(findEstateById(id));
    }

    protected List<Estate> getAllEstates() {
        return estateRepository.findAll();
    }

    public List<EstateDto> getAllEstateDtoList() {
        return estateDtoConverter.convertToEstateDtoList(getAllEstates());
    }

    public String deleteEstateById(Long id) {
        getEstateById(id);
        estateRepository.deleteById(id);
        return "Estate deleted successfully " + id;
    }

    public EstateDto createEstate(CreateEstateRequest createEstateRequest) {
        Customer customer = customerService.findCustomerById(createEstateRequest.getCustomerId());
        Estate estate = new Estate(
                createEstateRequest.getEstateType(),
                createEstateRequest.getSquareMeters(),
                createEstateRequest.getRoomNumber(),
                createEstateRequest.getFloorNumber(),
                createEstateRequest.getHeatingSystem(),
                customer
        );
        return estateDtoConverter.convert(estateRepository.save(estate));
    }

    public EstateDto updateEstate(Long id, UpdateEstateRequest updateEstateRequest) {
        Estate estate = findEstateById(id);
        Estate updateEstate = new Estate(
                estate.getId(),
                updateEstateRequest.getHeatingSystem(),
                estate.getCustomer()
        );

        return estateDtoConverter.convert(estateRepository.save(updateEstate));
    }

    public List<Estate> findEstatesByType(EstateType estateType) {
        return estateRepository.findByEstateType(estateType);
    }

    public List<Estate> search(EstateSearchRequest searchRequest) {
        return estateRepository.searchEstate(
                searchRequest.getEstateType(),
                searchRequest.getSquareMeters(),
                searchRequest.getRoomNumber(),
                searchRequest.getFloorNumber(),
                searchRequest.getHeatingSystem()
        );
    }
}
