package com.youngwoo.data.mapping

import com.youngwoo.data.model.ProfileCardEntity
import com.youngwoo.domain.model.ProfileCard

fun List<ProfileCardEntity>.toDomain(): List<ProfileCard> {
    return this.map {
        it.toDomain()
    }
}

fun ProfileCardEntity.toDomain() = ProfileCard(
    name = this.name,
    greetingMessage = this.greetingMessage,
    email = this.email,
    skills = this.skills.split(",")
)

