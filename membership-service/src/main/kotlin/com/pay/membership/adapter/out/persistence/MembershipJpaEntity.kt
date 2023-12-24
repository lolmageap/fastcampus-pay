package com.pay.membership.adapter.out.persistence

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "membership")
class MembershipJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = UUID.randomUUID().toString(),

    val name: String,

    val email: String,

    val address: String,

    val isValid: Boolean,

    val isCorp: Boolean,
) {

}
