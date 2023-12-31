package com.pay.membership.application.service

import com.pay.membership.adapter.out.persistence.MembershipMapper
import com.pay.membership.application.port.`in`.ModifyMembershipCommand
import com.pay.membership.application.port.`in`.ModifyMembershipUseCase
import com.pay.membership.application.port.out.ModifyMembershipPort
import com.pay.membership.domain.*
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ModifyMembershipService(
    private val modifyMembershipPort: ModifyMembershipPort,
    private val membershipMapper: MembershipMapper,
): ModifyMembershipUseCase {

    override fun modifyMembership(command: ModifyMembershipCommand): Membership {
        val membershipJpaEntity = modifyMembershipPort.modifyMembership(
            MembershipName(command.name),
            MembershipEmail(command.email),
            MembershipAddress(command.address),
            MembershipIsValid(command.isValid),
            MembershipIsCorp(command.isCorp),
        )
        return membershipMapper.mapToDomainEntity(membershipJpaEntity)
    }

}