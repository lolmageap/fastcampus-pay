package com.pay.membership.adapter.`in`.web

import com.common.WebAdapter
import com.pay.membership.application.port.`in`.FindMembershipCommand
import com.pay.membership.application.port.`in`.FindMembershipUseCase
import com.pay.membership.domain.Membership
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
class FindMembershipController(
    private val findMembershipUseCase: FindMembershipUseCase,
) {

    @GetMapping("/membership/{membership-id}")
    fun findMembershipById(
        @PathVariable("membership-id") membershipId: String,
    ): Membership {
        val command = FindMembershipCommand(membershipId)
        return findMembershipUseCase.findMembership(command)
    }

}