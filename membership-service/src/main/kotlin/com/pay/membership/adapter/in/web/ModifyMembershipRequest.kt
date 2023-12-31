package com.pay.membership.adapter.`in`.web

data class ModifyMembershipRequest(
    val name: String,
    val address: String,
    val email: String,
    val isValid: Boolean,
    val isCorp: Boolean,
) {

}