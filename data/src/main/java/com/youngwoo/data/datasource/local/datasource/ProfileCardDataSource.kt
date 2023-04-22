package com.youngwoo.data.datasource.local.datasource

import com.youngwoo.data.model.ProfileCardEntity

interface ProfileCardDataSource {
    suspend fun getAllMyProfileCard(): List<ProfileCardEntity>
}