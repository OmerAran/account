package com.omeraran.account.dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
        val id : String?,
        val balance : BigDecimal?,
        val creationDate : LocalDateTime?,
        val transactions : Set<TransactionDto>?

){}
