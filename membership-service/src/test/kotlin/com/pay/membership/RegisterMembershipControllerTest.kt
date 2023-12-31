package com.pay.membership

import com.fasterxml.jackson.databind.ObjectMapper
import com.pay.membership.adapter.`in`.web.RegisterMembershipRequest
import com.pay.membership.domain.*
import io.kotest.core.spec.style.StringSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class RegisterMembershipControllerTest(
    @Autowired private val mockMvc: MockMvc,
    @Autowired private val objectMapper: ObjectMapper,
): StringSpec({

    "register" {
        val request = RegisterMembershipRequest("name", "address", "email", false)
        val membership = Membership.generateMembership(
            membershipId = MembershipId("1"),
            membershipName = MembershipName("name"),
            membershipEmail = MembershipEmail("email"),
            membershipAddress = MembershipAddress("address"),
            membershipIsCorp = MembershipIsCorp(true),
            membershipIsValid = MembershipIsValid(false),
        )
        mockMvc.perform(
            MockMvcRequestBuilders.post("/membership")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(request))
        )
            .andExpect(MockMvcResultMatchers.status().isCreated)
            .andExpect(MockMvcResultMatchers.content().string(
                objectMapper.writeValueAsString(membership)
            ))
    }

})