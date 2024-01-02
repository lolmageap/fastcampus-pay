package com.pay.membership.adapter.out.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataBankAccountRepository: JpaRepository<BankAccountJpaEntity, String> {
}