package com.resume.backend.service

import com.resume.backend.entity.UserInfo
import com.resume.backend.repository.UserInfoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AccountService(@Autowired private val userInfoRepository: UserInfoRepository,
                     @Autowired private val passwordEncoder: PasswordEncoder): UserDetailsService {

    fun saveUserInfo(user: UserInfo): UserInfo {
        user.password = this.passwordEncoder.encode(user.password)
        return userInfoRepository.save(user)
    }

    override fun loadUserByUsername(loginId: String): UserDetails {
        return userInfoRepository.findByLoginId(loginId)?.getAuthorities()
                ?: throw UsernameNotFoundException("$loginId Can Not Found")
    }
}