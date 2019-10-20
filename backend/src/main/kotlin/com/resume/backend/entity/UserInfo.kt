package com.resume.backend.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User

import java.math.BigInteger
import java.time.LocalDateTime
import java.util.stream.Collectors
import javax.persistence.*

@Entity
data class UserInfo(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: BigInteger? = null,
        var name: String,
        var loginId: String,
        var password: String,

        @Enumerated(EnumType.STRING)
        @ElementCollection(fetch = FetchType.EAGER)
        var roles: MutableSet<AccountRole>,

        @CreationTimestamp
        var regDate: LocalDateTime = LocalDateTime.now(),
        @UpdateTimestamp
        var uptDate: LocalDateTime = LocalDateTime.now()


){
  fun getAuthorities(): User {
                return User(
                        this.loginId, this.password,
                        this.roles.stream().map { role -> SimpleGrantedAuthority("ROLE_$role") }.collect(Collectors.toSet())
                )
        }
}
