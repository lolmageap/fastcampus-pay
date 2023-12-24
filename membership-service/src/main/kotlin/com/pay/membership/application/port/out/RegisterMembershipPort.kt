package com.pay.membership.application.port.out

import com.pay.membership.adapter.out.persistence.MembershipJpaEntity
import com.pay.membership.domain.Membership.Companion.MembershipAddress
import com.pay.membership.domain.Membership.Companion.MembershipEmail
import com.pay.membership.domain.Membership.Companion.MembershipId
import com.pay.membership.domain.Membership.Companion.MembershipIsCorp
import com.pay.membership.domain.Membership.Companion.MembershipIsValid
import com.pay.membership.domain.Membership.Companion.MembershipName

interface RegisterMembershipPort {
    fun createMembership(
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ): MembershipJpaEntity
}