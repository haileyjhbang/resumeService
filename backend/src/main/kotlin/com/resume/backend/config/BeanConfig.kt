package com.resume.backend.config

import com.resume.backend.entity.AccountRole
import com.resume.backend.entity.UserInfo
import com.resume.backend.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class BeanConfig {
    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

    @Bean
    fun applicationRunner(): ApplicationRunner {
        return object : ApplicationRunner {

            @Autowired
            lateinit var accountService: AccountService

            @Throws(Exception::class)
            override fun run(args: ApplicationArguments) {
                /*val admin = UserInfo(null,
                        "administrator",
                        "admin",
                        "1234567890",
                        mutableSetOf(AccountRole.ADMIN, AccountRole.USER))
                accountService.saveUserInfo(admin)*/
            }
        }
    }
}