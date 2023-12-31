package com.pay.membership.application.port.`in`

import com.common.UseCase
import com.pay.membership.domain.Membership

@UseCase
interface ModifyMembershipUseCase {

    fun modifyMembership(command: ModifyMembershipCommand): Membership
}