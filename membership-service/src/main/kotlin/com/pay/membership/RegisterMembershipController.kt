package com.pay.membership

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RegisterMembershipController {

    @GetMapping("/test")
    fun test() = "hello world"

}