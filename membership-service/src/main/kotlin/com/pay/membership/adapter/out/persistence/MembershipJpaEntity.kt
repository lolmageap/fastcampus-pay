package com.pay.membership.adapter.out.persistence

import jakarta.persistence.*

@Entity
@Table(name = "membership")
class MembershipJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val email: String,

    val address: String,

    val isValid: Boolean,

    val isCorp: Boolean,
) {

}
