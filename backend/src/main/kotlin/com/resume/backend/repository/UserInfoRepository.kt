package com.resume.backend.repository

import com.resume.backend.entity.UserInfo
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigInteger

interface UserInfoRepository: JpaRepository<UserInfo, BigInteger> {
    fun findByLoginId(loginId: String): UserInfo?
}