package com.pay.membership.adapter.`in`.web

import com.common.WebAdapter
import com.pay.membership.application.port.`in`.ModifyMembershipCommand
import com.pay.membership.application.port.`in`.ModifyMembershipUseCase
import com.pay.membership.domain.Membership
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
class ModifyMembershipController(
    private val modifyMembershipUseCase: ModifyMembershipUseCase,
) {

    @PutMapping("/membership/{membership-id}")
    fun modifyMembershipById(
        @PathVariable("membership-id") membershipId: String,
        @RequestBody request: ModifyMembershipRequest,
    ): Membership {

        val command = ModifyMembershipCommand(
            name = request.name,
            address = request.address,
            email = request.email,
            isValid = request.isValid,
            isCorp = request.isCorp,
        )

        return modifyMembershipUseCase.modifyMembership(command)
    }

}