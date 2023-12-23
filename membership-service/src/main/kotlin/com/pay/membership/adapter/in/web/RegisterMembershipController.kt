package com.pay.membership.adapter.`in`.web

import com.common.WebAdapter
import com.pay.membership.application.port.`in`.RegisterMembershipCommand
import com.pay.membership.application.port.`in`.RegisterMembershipUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
class RegisterMembershipController(
    private val registerMembershipUseCase: RegisterMembershipUseCase,
) {

    @PostMapping("/membership")
    fun registerMembership(
        @RequestBody request: RegisterMembershipRequest,
    ) {
        // TODO : 1. request

        // TODO : 2. request -> command

        // TODO : 3. use case ~~

        val command = RegisterMembershipCommand(
            name = request.name,
            address = request.address,
            email = request.email,
            isValid = true,
            isCorp = request.isCorp,
        )

        registerMembershipUseCase.registerMembership(command)
    }

}