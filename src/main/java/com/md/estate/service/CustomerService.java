package com.md.estate.service;

import com.md.estate.dto.CustomerDto;
import com.md.estate.dto.converter.CustomerDtoConverter;
import com.md.estate.dto.converter.EstateDtoConverter;
import com.md.estate.dto.request.CreateCustomerRequest;
import com.md.estate.dto.request.UpdateCustomerRequest;
import com.md.estate.exception.CustomerNotFoundException;
import com.md.estate.model.Business;
import com.md.estate.model.Customer;
import com.md.estate.model.Estate;
import com.md.estate.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    private final EstateDtoConverter estateDtoConverter;
    private final BusinessService businessService;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerDtoConverter customerDtoConverter,
                           EstateDtoConverter estateDtoConverter, BusinessService businessService) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
        this.estateDtoConverter = estateDtoConverter;
        this.businessService = businessService;
    }

    protected Customer findCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found " + id));
    }

    public CustomerDto getCustomerById(Long id) {
        return customerDtoConverter.convert(findCustomerById(id));
    }

    protected List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<CustomerDto> getAllCustomerDtoList() {
        return customerDtoConverter.convertToCustomerDtoList(getAllCustomers());
    }

    public String deleteCustomerById(Long id) {
        getCustomerById(id);
        customerRepository.deleteById(id);
        return "Customer deleted successfully " + id;
    }

    public CustomerDto createCustomer(CreateCustomerRequest createCustomerRequest) {
        Business business = businessService.findBusinessById(createCustomerRequest.getBusinessId());

        List<Estate> estates = new ArrayList<>();
        if (createCustomerRequest.getEstateList() != null) {
            estates = estateDtoConverter.convertToEstateList(createCustomerRequest.getEstateList());
        }

        Customer customer = new Customer(
                createCustomerRequest.getName(),
                createCustomerRequest.getSurname(),
                createCustomerRequest.getHomePhoneNumber(),
                createCustomerRequest.getMobilePhoneNumber(),
                createCustomerRequest.getEmailAddress(),
                business,
                estates
        );
        customer.setEstate(estates);
        return customerDtoConverter.convert(customerRepository.save(customer));
    }

    public CustomerDto updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = findCustomerById(id);
        Business business = businessService.findBusinessById(updateCustomerRequest.getBusinessId());
        List<Estate> estates = estateDtoConverter.convertToEstateList(updateCustomerRequest.getEstateList());

        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setHomePhoneNumber(updateCustomerRequest.getHomePhoneNumber());
        customer.setMobilePhoneNumber(updateCustomerRequest.getMobilePhoneNumber());
        customer.setEmailAddress(updateCustomerRequest.getEmailAddress());
        customer.setBusiness(business);
        customer.setEstate(estates);

        return customerDtoConverter.convert(customerRepository.save(customer));
    }

}
