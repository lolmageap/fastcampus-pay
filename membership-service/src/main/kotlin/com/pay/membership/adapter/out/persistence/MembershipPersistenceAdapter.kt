package com.pay.membership.adapter.out.persistence

import com.common.PersistenceAdapter
import com.pay.membership.application.port.out.FindMembershipPort
import com.pay.membership.application.port.out.ModifyMembershipPort
import com.pay.membership.application.port.out.RegisterMembershipPort
import com.pay.membership.domain.*
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
class MembershipPersistenceAdapter(
    private val membershipRepository: SpringDataMembershipRepository,
) : RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {
    override fun createMembership(
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ) =
        membershipRepository.save(
            MembershipJpaEntity(
                name = membershipName.name,
                email = membershipEmail.email,
                address = membershipAddress.address,
                isValid = membershipIsValid.isValid,
                isCorp = membershipIsCorp.isCorp,
            )
        )

    override fun findMembership(membershipId: MembershipId): MembershipJpaEntity =
        membershipRepository.findByIdOrNull(membershipId.id)
            ?: throw IllegalStateException()

    override fun modifyMembership(
        membershipId: MembershipId,
        membershipName: MembershipName,
        membershipEmail: MembershipEmail,
        membershipAddress: MembershipAddress,
        membershipIsValid: MembershipIsValid,
        membershipIsCorp: MembershipIsCorp,
    ) =
        membershipRepository.findByIdOrNull(membershipId.id)
            ?.apply {
                name = membershipName.name
                address = membershipAddress.address
                email = membershipEmail.email
                isCorp = membershipIsCorp.isCorp
                isValid = membershipIsValid.isValid
            }
            ?: throw IllegalStateException()

}
