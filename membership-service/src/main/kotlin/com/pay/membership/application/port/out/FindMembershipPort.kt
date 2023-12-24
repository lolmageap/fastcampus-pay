package com.pay.membership.application.port.out

import com.pay.membership.adapter.out.persistence.MembershipJpaEntity
import com.pay.membership.domain.Membership.Companion.MembershipId

interface FindMembershipPort {
    fun findMembership(membershipId: MembershipId): MembershipJpaEntity
}