package com.pay.membership.application.service

import com.pay.membership.application.port.`in`.RegisterMembershipCommand
import com.pay.membership.application.port.`in`.RegisterMembershipUseCase
import com.pay.membership.domain.Membership
import org.springframework.stereotype.Service

@Service
class RegisterMembershipService: RegisterMembershipUseCase {
    override fun registerMembership(command: RegisterMembershipCommand): Membership {
        TODO("Not yet implemented")
    }

}