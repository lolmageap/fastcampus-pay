package com.pay.settlement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SettlementApplication

fun main(args: Array<String>) {
    runApplication<MoneyApplication>(*args)
}