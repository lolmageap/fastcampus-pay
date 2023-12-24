package com.pay.membership.application.service

import com.pay.membership.domain.*

import com.pay.membership.adapter.out.persistence.MembershipMapper
import com.pay.membership.application.port.`in`.RegisterMembershipCommand
import com.pay.membership.application.port.`in`.RegisterMembershipUseCase
import com.pay.membership.application.port.out.RegisterMembershipPort
import com.pay.membership.domain.Membership
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class RegisterMembershipService(
    private val registerMembershipPort: RegisterMembershipPort,
    private val membershipMapper: MembershipMapper,
): RegisterMembershipUseCase {
    override fun registerMembership(command: RegisterMembershipCommand): Membership {

        val membershipJpaEntity = registerMembershipPort.createMembership(
            MembershipName(command.name),
            MembershipEmail(command.email),
            MembershipAddress(command.address),
            MembershipIsValid(command.isValid),
            MembershipIsCorp(command.isCorp),
        )

        return membershipMapper.mapToDomainEntity(membershipJpaEntity)
    }

}