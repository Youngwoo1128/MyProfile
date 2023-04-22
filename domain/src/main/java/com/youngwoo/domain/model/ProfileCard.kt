package com.youngwoo.domain.model

data class ProfileCard(
    val name: String,
    val greetingMessage: String,
    val email: String,
    val skills: List<String>
)