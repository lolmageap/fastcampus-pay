package com.pay.membership.domain

import jakarta.persistence.Entity

@Entity
class Membership(
    val id: String,
    val name: String,
    val email: String,
    val address: String,
    val isValid: Boolean,
    val isCorp: Boolean,
) {

}