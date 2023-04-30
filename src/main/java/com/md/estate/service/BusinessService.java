package com.md.estate.service;

import com.md.estate.dto.BusinessDto;
import com.md.estate.dto.converter.BusinessDtoConverter;
import com.md.estate.dto.request.CreateBusinessRequest;
import com.md.estate.dto.request.UpdateBusinessRequest;
import com.md.estate.exception.BusinessNotFoundException;
import com.md.estate.model.Business;
import com.md.estate.repository.BusinessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessService {

    private final BusinessRepository businessRepository;
    private final BusinessDtoConverter businessDtoConverter;

    public BusinessService(BusinessRepository businessRepository, BusinessDtoConverter businessDtoConverter) {
        this.businessRepository = businessRepository;
        this.businessDtoConverter = businessDtoConverter;
    }

    protected Business findBusinessById(Long id) {
        return businessRepository.findById(id)
                .orElseThrow(() -> new BusinessNotFoundException("Business not found with id " + id));
    }

    public BusinessDto getBusinessById(Long id) {
        return businessDtoConverter.convert(findBusinessById(id));
    }

    public List<BusinessDto> getAllBusinesses() {
        List<Business> businessList = businessRepository.findAll();
        return businessDtoConverter.convertToBusinessDtoList(businessList);
    }

    public BusinessDto createBusiness(CreateBusinessRequest createBusinessRequest) {
        Business business = new Business(
                createBusinessRequest.getBusinessName(),
                createBusinessRequest.getAddress(),
                createBusinessRequest.getPhone(),
                createBusinessRequest.getFax()
        );
        return businessDtoConverter.convert(businessRepository.save(business));
    }

    public BusinessDto updateBusiness(Long id, UpdateBusinessRequest updateBusinessRequest) {
        Business business = findBusinessById(id);
        business.setAddress(updateBusinessRequest.getAddress());
        business.setPhone(updateBusinessRequest.getPhone());
        business.setFax(updateBusinessRequest.getFax());

        return businessDtoConverter.convert(businessRepository.save(business));
    }

    public String deleteBusinessById(Long id) {
        getBusinessById(id);
        businessRepository.deleteById(id);
        return "Business deleted successfully with id " + id;
    }
}
