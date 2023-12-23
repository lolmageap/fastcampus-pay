package com.pay.membership.adapter.`in`.web

import com.common.WebAdapter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@WebAdapter
@RestController
class RegisterMembershipController {

    @GetMapping("/test")
    fun test() = "hello world"

}