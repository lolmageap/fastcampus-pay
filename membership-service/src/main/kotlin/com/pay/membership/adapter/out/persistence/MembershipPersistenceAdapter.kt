package com.pay.membership.adapter.out.persistence

import com.pay.membership.domain.Membership.Companion.MembershipAddress
import com.pay.membership.domain.Membership.Companion.MembershipEmail
import com.pay.membership.domain.Membership.Companion.MembershipId
import com.pay.membership.domain.Membership.Companion.MembershipIsCorp
import com.pay.membership.domain.Membership.Companion.MembershipIsValid
import com.pay.membership.domain.Membership.Companion.MembershipName
import com.common.PersistenceAdapter
import com.pay.membership.application.port.out.FindMembershipPort
import com.pay.membership.application.port.out.RegisterMembershipPort
import org.springframework.data.repository.findByIdOrNull
import java.lang.IllegalStateException

@PersistenceAdapter
class MembershipPersistenceAdapter(
    private val membershipRepository: SpringDataMembershipRepository,
): RegisterMembershipPort, FindMembershipPort {
    override fun createMembership(
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ): MembershipJpaEntity {
        return membershipRepository.save(
            MembershipJpaEntity(
                name = membershipName.name,
                email = membershipEmail.email,
                address = membershipAddress.address,
                isValid = membershipIsValid.isValid,
                isCorp = membershipIsCorp.isCorp,
            )
        )
    }

    override fun findMembership(membershipId: MembershipId): MembershipJpaEntity =
        membershipRepository.findByIdOrNull(membershipId.id)
            ?: throw IllegalStateException()

}
