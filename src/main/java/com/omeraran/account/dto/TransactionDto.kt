package com.omeraran.account.dto

import com.omeraran.account.model.Account
import com.omeraran.account.model.TransactionType
import java.math.BigDecimal
import java.time.LocalDateTime

data class TransactionDto(
        val id : String?,
        val transactionType : TransactionType?,
        val amount : BigDecimal?,
        val transactionDate : LocalDateTime?
)