package com.omeraran.account.service;

import com.omeraran.account.dto.CustomerDto;
import com.omeraran.account.dto.converter.CustomerDtoConverter;
import com.omeraran.account.exception.CustomerNotFoundException;
import com.omeraran.account.model.Customer;
import com.omeraran.account.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
public class CustomerServiceTest {

    private CustomerService service;
    private CustomerRepository repository;
    private CustomerDtoConverter converter;

    @BeforeEach
    public void setUp(){
        repository = Mockito.mock(CustomerRepository.class);
        converter = Mockito.mock(CustomerDtoConverter.class);
        service = new CustomerService(repository,converter);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer("id", "name", "surname", Set.of());

        Mockito.when(repository.findById("id")).thenReturn(Optional.of(customer));

        Customer result = service.findCustomerById("id");

       assertEquals(result,
               customer);
    }

    @Test
    public void testFindByCustomerId_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){

        Mockito.when(repository.findById("id")).thenReturn(Optional.empty());

       assertThrows(CustomerNotFoundException.class,
               () -> service.findCustomerById("id"));
    }

    @Test
    public void testGetCustomerById_whenCustomerIdExists_shouldReturnCustomer(){
        Customer customer = new Customer("id", "name", "surname", Set.of());
        CustomerDto customerDto = new CustomerDto("id", "name", "surname", Set.of());

        Mockito.when(repository.findById("id")).thenReturn(Optional.of(customer));
        Mockito.when(converter.convertToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto result = service.getCustomerById("id");

        assertEquals(result,
                customerDto);
    }

    @Test
    public void testGetCustomerById_whenCustomerIdDoesNotExists_shouldThrowCustomerNotFoundException(){
        Mockito.when(repository.findById("id")).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class,
               ()-> service.getCustomerById("id"));

        Mockito.verifyNoInteractions(converter);
    }
}