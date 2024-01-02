package com.pay.membership.adapter.`in`.web

data class RegisterBankAccountRequest(
    val name: String,
    val address: String,
    val email: String,
    val isCorp: Boolean,
) {

}