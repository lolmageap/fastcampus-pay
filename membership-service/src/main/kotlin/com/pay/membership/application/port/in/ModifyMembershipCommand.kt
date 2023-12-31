package com.pay.membership.application.port.`in`

import com.common.SelfValidating
import jakarta.validation.constraints.NotBlank

data class ModifyMembershipCommand(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val address: String,

    @field:NotBlank
    val email: String,

    val isValid: Boolean,

    val isCorp: Boolean,

): SelfValidating<ModifyMembershipCommand>() {

    init {
        validateSelf()
    }

}