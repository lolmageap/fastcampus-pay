package com.pay.membership.application.port.`in`

import com.common.SelfValidating
import jakarta.validation.constraints.NotBlank

data class FindMembershipCommand(

    @field:NotBlank
    val membershipId: String,

): SelfValidating<FindMembershipCommand>() {

    init {
        validateSelf()
    }

}