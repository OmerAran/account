package com.omeraran.account.service;

import com.omeraran.account.constant.AbstractConstant;
import com.omeraran.account.dto.CustomerDto;
import com.omeraran.account.dto.converter.CustomerDtoConverter;
import com.omeraran.account.exception.CustomerNotFoundException;
import com.omeraran.account.model.Customer;
import com.omeraran.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id){
      return customerRepository.findById(id)
              .orElseThrow(
                      () -> new CustomerNotFoundException(AbstractConstant.CUSTOMER_NOT_FOUND_BY_ID+" : "+id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}
