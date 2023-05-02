package com.md.estate.controller;

import com.md.estate.dto.CustomerDto;
import com.md.estate.dto.request.CreateCustomerRequest;
import com.md.estate.dto.request.UpdateCustomerRequest;
import com.md.estate.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.deleteCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        List<CustomerDto> customerDtoList = customerService.getAllCustomerDtoList();
        return ResponseEntity.ok(customerDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updateCustomerRequest));
    }
}
