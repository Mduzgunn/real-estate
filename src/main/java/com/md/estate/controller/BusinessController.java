package com.md.estate.controller;

import com.md.estate.dto.BusinessDto;
import com.md.estate.dto.request.CreateBusinessRequest;
import com.md.estate.dto.request.UpdateBusinessRequest;
import com.md.estate.service.BusinessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/businesses")
public class BusinessController {
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBusinessById(@PathVariable Long id) {
        return ResponseEntity.ok(businessService.deleteBusinessById(id));
    }

    @GetMapping
    public ResponseEntity<List<BusinessDto>> getAllBusinesses() {
        List<BusinessDto> businessDtoList = businessService.getAllBusinesses();
        return ResponseEntity.ok(businessDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessDto> getBusinessById(@PathVariable Long id) {
        BusinessDto businessDto = businessService.getBusinessById(id);
        return ResponseEntity.ok(businessDto);
    }

    @PostMapping
    public ResponseEntity<BusinessDto> createBusiness(@RequestBody CreateBusinessRequest createBusinessRequest) {
        return ResponseEntity.ok(businessService.createBusiness(createBusinessRequest));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BusinessDto> updateBusiness(@PathVariable Long id, @RequestBody UpdateBusinessRequest updateBusinessRequest) {
        return ResponseEntity.ok(businessService.updateBusiness(id, updateBusinessRequest));
    }
}
