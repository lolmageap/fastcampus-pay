package com.pay.membership.adapter.out.persistence

import com.pay.membership.domain.Membership
import org.springframework.stereotype.Component

@Component
class MembershipMapper {
    fun mapToDomainEntity(jpaEntity: MembershipJpaEntity): Membership {
        return Membership.generateMembership(
            membershipId = Membership.Companion.MembershipId(jpaEntity.id),
            membershipName = Membership.Companion.MembershipName(jpaEntity.name),
            membershipEmail = Membership.Companion.MembershipEmail(jpaEntity.email),
            membershipAddress = Membership.Companion.MembershipAddress(jpaEntity.address),
            membershipIsCorp = Membership.Companion.MembershipIsCorp(jpaEntity.isCorp),
            membershipIsValid = Membership.Companion.MembershipIsValid(jpaEntity.isValid),
        )
    }
}