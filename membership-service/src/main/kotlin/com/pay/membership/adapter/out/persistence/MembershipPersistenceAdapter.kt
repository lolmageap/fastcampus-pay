package com.pay.membership.adapter.out.persistence

import com.pay.membership.domain.*

import com.common.PersistenceAdapter
import com.pay.membership.application.port.out.FindMembershipPort
import com.pay.membership.application.port.out.ModifyMembershipPort
import com.pay.membership.application.port.out.RegisterMembershipPort
import org.springframework.data.repository.findByIdOrNull
import java.lang.IllegalStateException

@PersistenceAdapter
class MembershipPersistenceAdapter(
    private val membershipRepository: SpringDataMembershipRepository,
): RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {
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

    override fun modifyMembership(
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ): MembershipJpaEntity {
        TODO("Not yet implemented")
    }

}
