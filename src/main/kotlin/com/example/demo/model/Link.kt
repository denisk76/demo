package com.example.demo.model

import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Link(
        var text: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0
)