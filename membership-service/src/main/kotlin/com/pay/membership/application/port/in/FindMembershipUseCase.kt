package com.pay.membership.application.port.`in`

import com.common.UseCase
import com.pay.membership.domain.Membership

@UseCase
interface FindMembershipUseCase {

    fun findMembership(command: FindMembershipCommand): Membership
}