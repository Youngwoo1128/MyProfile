package com.youngwoo.domain.model

sealed class ProfileCardResult {
    data class Success(val profileCards: List<ProfileCard>): ProfileCardResult()
    object NonProfileCard: ProfileCardResult()
    data class Fail(val exception: Throwable): ProfileCardResult()
}