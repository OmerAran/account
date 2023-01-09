package com.omeraran.account.dto.converter;

import com.omeraran.account.dto.TransactionDto;
import com.omeraran.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from){
        return new TransactionDto(
                from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());
    }
}
