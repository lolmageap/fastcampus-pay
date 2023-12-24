package com.pay.membership.application.service

import com.pay.membership.adapter.out.persistence.MembershipMapper
import com.pay.membership.application.port.`in`.FindMembershipCommand
import com.pay.membership.application.port.`in`.FindMembershipUseCase
import com.pay.membership.application.port.out.FindMembershipPort
import com.pay.membership.domain.Membership
import com.pay.membership.domain.MembershipId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FindMembershipService(
    private val findMembershipPort: FindMembershipPort,
    private val membershipMapper: MembershipMapper,
): FindMembershipUseCase {
    override fun findMembership(command: FindMembershipCommand): Membership {
        val membershipEntity = findMembershipPort.findMembership(
            MembershipId(command.membershipId)
        )
        return membershipMapper.mapToDomainEntity(membershipEntity)
    }

}