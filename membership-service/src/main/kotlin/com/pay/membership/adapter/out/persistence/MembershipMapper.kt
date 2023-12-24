package com.pay.membership.adapter.out.persistence

import com.pay.membership.domain.*
import org.springframework.stereotype.Component

@Component
class MembershipMapper {
    fun mapToDomainEntity(jpaEntity: MembershipJpaEntity): Membership {
        return Membership.generateMembership(
            membershipId = MembershipId(jpaEntity.id),
            membershipName = MembershipName(jpaEntity.name),
            membershipEmail = MembershipEmail(jpaEntity.email),
            membershipAddress = MembershipAddress(jpaEntity.address),
            membershipIsCorp = MembershipIsCorp(jpaEntity.isCorp),
            membershipIsValid = MembershipIsValid(jpaEntity.isValid),
        )
    }
}