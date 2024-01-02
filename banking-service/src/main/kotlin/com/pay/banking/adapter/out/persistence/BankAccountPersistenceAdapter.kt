package com.pay.membership.adapter.out.persistence

import com.common.PersistenceAdapter
import com.pay.membership.application.port.out.FindMembershipPort
import com.pay.membership.application.port.out.ModifyMembershipPort
import com.pay.membership.application.port.out.RegisterMembershipPort
import com.pay.membership.domain.*
import org.springframework.data.repository.findByIdOrNull

@PersistenceAdapter
class BankAccountPersistenceAdapter(
    private val bankAccountRepository: SpringDataBankAccountRepository,
) : RegisterBankAccountPort {

}
