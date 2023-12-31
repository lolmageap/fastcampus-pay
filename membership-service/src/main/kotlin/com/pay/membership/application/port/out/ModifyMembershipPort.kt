package com.pay.membership.application.port.out

import com.pay.membership.domain.*
import com.pay.membership.adapter.out.persistence.MembershipJpaEntity

interface ModifyMembershipPort {
    fun modifyMembership(
        membershipId: MembershipId,
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ): MembershipJpaEntity
}