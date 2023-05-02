package com.md.estate.service;

import com.md.estate.dto.CustomerDto;
import com.md.estate.dto.converter.CustomerDtoConverter;
import com.md.estate.dto.request.CreateCustomerRequest;
import com.md.estate.dto.request.UpdateCustomerRequest;
import com.md.estate.exception.CustomerNotFoundException;
import com.md.estate.model.Customer;
import com.md.estate.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
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

        Customer customer = new Customer(
                createCustomerRequest.getName(),
                createCustomerRequest.getSurname(),
                createCustomerRequest.getHomePhoneNumber(),
                createCustomerRequest.getMobilePhoneNumber(),
                createCustomerRequest.getEmailAddress()
        );
        return customerDtoConverter.convert(customerRepository.save(customer));
    }

    public CustomerDto updateCustomer(Long id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = findCustomerById(id);

        customer.setName(updateCustomerRequest.getName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setHomePhoneNumber(updateCustomerRequest.getHomePhoneNumber());
        customer.setMobilePhoneNumber(updateCustomerRequest.getMobilePhoneNumber());
        customer.setEmailAddress(updateCustomerRequest.getEmailAddress());

        return customerDtoConverter.convert(customerRepository.save(customer));
    }

}
