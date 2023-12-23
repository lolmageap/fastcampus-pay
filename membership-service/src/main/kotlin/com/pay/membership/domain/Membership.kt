package com.pay.membership.domain

class Membership private constructor(
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

        class MembershipId {
            fun membershipId(value: String) {
                this.id = value
            }

            lateinit var id: String
        }

        class MembershipName {
            fun membershipName(value: String) {
                this.name = value
            }

            lateinit var name: String
        }

        class MembershipEmail {
            fun membershipEmail(value: String) {
                this.email = value
            }

            lateinit var email: String
        }

        class MembershipAddress {
            fun membershipAddress(value: String) {
                this.address = value
            }

            lateinit var address: String
        }

        class MembershipIsValid {
            fun membershipIsValid(value: Boolean) {
                this.isValid = value
            }

            var isValid: Boolean = false
        }

        class MembershipIsCorp {
            fun membershipIsCorp(value: Boolean) {
                this.isCorp = value
            }

            var isCorp: Boolean = false
        }
    }
}