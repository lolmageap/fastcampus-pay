package com.pay.membership.application.port.`in`

import com.common.SelfValidating
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.NotBlank

data class RegisterMembershipCommand(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val address: String,

    @field:NotBlank
    val email: String,

    @field:AssertTrue
    val isValid: Boolean,

    val isCorp: Boolean,

): SelfValidating<RegisterMembershipCommand>() {

    init {
        validateSelf()
    }

}