package com.omeraran.account.dto.converter;

import com.omeraran.account.dto.AccountCustomerDto;
import com.omeraran.account.dto.CustomerAccountDto;
import com.omeraran.account.dto.CustomerDto;
import com.omeraran.account.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final CustomerAccountDtoConverter customerAccountDtoConverter;

    public CustomerDtoConverter(CustomerAccountDtoConverter customerAccountDtoConverter){
        this.customerAccountDtoConverter = customerAccountDtoConverter;
    }

    public AccountCustomerDto convertToAccountCustomer(Optional<Customer> from) {
        return from.map(f -> new AccountCustomerDto(f.getId(), f.getName(), f.getSurname())).orElse(null);
    }

    public CustomerDto convertToCustomerDto(Customer from){
        return new CustomerDto(
                from.getId(),
                from.getName(),
                from.getSurname(),
                from.getAccounts()
                        .stream()
                        .map(customerAccountDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}
