package com.pay.membership.adapter.`in`.web

import com.common.WebAdapter
import com.pay.membership.application.port.`in`.RegisterMembershipCommand
import com.pay.membership.application.port.`in`.RegisterMembershipUseCase
import com.pay.membership.domain.Membership
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
class RegisterBankAccountController(
    private val registerMembershipUseCase: RegisterMembershipUseCase,
) {

    @PostMapping("/membership")
    fun registerMembership(
        @RequestBody request: RegisterMembershipRequest,
    ): Membership {
        val command = RegisterMembershipCommand(
            name = request.name,
            address = request.address,
            email = request.email,
            isValid = true,
            isCorp = request.isCorp,
        )

       return registerMembershipUseCase.registerMembership(command)
    }

}