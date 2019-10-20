package com.resume.backend.entity

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Category(
    @Id
    var id: String,
    var value: String,
    var type: String
)