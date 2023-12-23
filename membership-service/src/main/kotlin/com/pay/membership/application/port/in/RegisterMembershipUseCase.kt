package com.pay.membership.application.port.`in`

import com.common.UseCase
import com.pay.membership.domain.Membership

@UseCase
interface RegisterMembershipUseCase {

    fun registerMembership(command: RegisterMembershipCommand): Membership
}