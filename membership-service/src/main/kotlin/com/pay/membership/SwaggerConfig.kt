package com.pay.membership

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityRequirement
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI {
        val info = Info()
            .title("membership")
            .version("v1")
            .description("Open Api")

        val securityScheme = SecurityScheme()
            .type(SecurityScheme.Type.APIKEY)
            .scheme("apiKey")
            .name("Authorization")
            .`in`(SecurityScheme.In.HEADER)

        val securityRequirement = SecurityRequirement().addList("Auth")
        return OpenAPI().components(
            Components().addSecuritySchemes("Auth", securityScheme)
        )
            .info(info)
            .security(
                mutableListOf(securityRequirement)
            )
    }

}