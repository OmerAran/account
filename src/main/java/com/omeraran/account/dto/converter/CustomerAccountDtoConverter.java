package com.omeraran.account.dto.converter;

import com.omeraran.account.dto.AccountDto;
import com.omeraran.account.dto.CustomerAccountDto;
import com.omeraran.account.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter){
       this.transactionDtoConverter = transactionDtoConverter;
    }

    public CustomerAccountDto convert(Account from){
        return new CustomerAccountDto(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getCreationDate(),
                from.getTransactions()
                        .stream().
                        map(transactionDtoConverter::convert)
                        .collect(Collectors.toSet()));
    }
}
