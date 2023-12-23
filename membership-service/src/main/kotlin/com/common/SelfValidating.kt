package com.common

import jakarta.validation.Validation
import jakarta.validation.Validator

abstract class SelfValidating<T>(
    private val validator: Validator = Validation.buildDefaultValidatorFactory().validator,
) {
}