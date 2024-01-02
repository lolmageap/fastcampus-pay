package com.pay.membership.domain

class RegisteredBankAccount private constructor(
    val id: String,
    val name: String,
    val email: String,
    val address: String,
    val isValid: Boolean,
    val isCorp: Boolean,
) {
    companion object {
        fun generateMembership(
            membershipId: MembershipId,
            membershipName: MembershipName,
            membershipEmail: MembershipEmail,
            membershipAddress: MembershipAddress,
            membershipIsValid: MembershipIsValid,
            membershipIsCorp: MembershipIsCorp,
        ): Membership = Membership(
            id = membershipId.id,
            name = membershipName.name,
            email = membershipEmail.email,
            address = membershipAddress.address,
            isValid = membershipIsValid.isValid,
            isCorp = membershipIsCorp.isCorp,
        )
    }
}

class MembershipId(val id: String)

class MembershipName(val name: String)

class MembershipEmail(val email: String)

class MembershipAddress(val address: String)

class MembershipIsValid(val isValid: Boolean = false)

class MembershipIsCorp(val isCorp: Boolean = false)