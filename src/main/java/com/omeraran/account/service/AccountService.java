package com.omeraran.account.service;

import com.omeraran.account.dto.AccountDto;
import com.omeraran.account.dto.CreateAccountRequest;
import com.omeraran.account.dto.converter.AccountDtoConverter;
import com.omeraran.account.model.Account;
import com.omeraran.account.model.Customer;
import com.omeraran.account.model.Transaction;
import com.omeraran.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest){
        Customer customer = customerService.findCustomerById(createAccountRequest.getCustomerId());

        Account account = new Account(
                customer,
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now()
        );

        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0 ) {
            Transaction transaction = new Transaction(account, createAccountRequest.getInitialCredit());
            account.getTransactions().add(transaction);
        }

        return converter.convert(accountRepository.save(account));
    }
}
