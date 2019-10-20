package com.resume.backend.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigInteger
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Detail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: BigInteger,
    var broadId: BigInteger,
    var title: String,
    var detail: String,
    var startDate: String,
    var endDate: String,
    var ord: Integer,
    @CreationTimestamp
    var regDate: LocalDateTime = LocalDateTime.now(),
    @UpdateTimestamp
    var uptDate: LocalDateTime = LocalDateTime.now()
)