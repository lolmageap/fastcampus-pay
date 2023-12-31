package com.pay.membership.adapter.out.persistence

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "membership")
class MembershipJpaEntity(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    val id: String = UUID.randomUUID().toString(),

    var name: String,

    var email: String,

    var address: String,

    var isValid: Boolean,

    var isCorp: Boolean,
) {

}
