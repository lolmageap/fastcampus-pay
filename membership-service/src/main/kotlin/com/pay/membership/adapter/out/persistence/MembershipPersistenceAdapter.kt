package com.pay.membership.adapter.out.persistence

import com.pay.membership.domain.Membership.Companion.MembershipAddress
import com.pay.membership.domain.Membership.Companion.MembershipEmail
import com.pay.membership.domain.Membership.Companion.MembershipId
import com.pay.membership.domain.Membership.Companion.MembershipIsCorp
import com.pay.membership.domain.Membership.Companion.MembershipIsValid
import com.pay.membership.domain.Membership.Companion.MembershipName
import com.common.PersistenceAdapter
import com.pay.membership.application.port.out.RegisterMembershipPort

@PersistenceAdapter
class MembershipPersistenceAdapter(
    private val membershipRepository: SpringDataMembershipRepository,
): RegisterMembershipPort{
    override fun createMembership(
        membershipId: MembershipId,
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ) {
        membershipRepository.save(
            MembershipJpaEntity(
                name = membershipName.name,
                email = membershipEmail.email,
                address = membershipAddress.address,
                isValid = membershipIsValid.isValid,
                isCorp = membershipIsCorp.isCorp,
            )
        )
    }

}
