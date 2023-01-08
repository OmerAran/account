package com.omeraran.account.dto

import com.omeraran.account.model.Account

data class CustomerDto(
        val id: String?,
        val name : String?,
        val surname : String?,
        val accounts : Set<CustomerAccountDto>
) {
}