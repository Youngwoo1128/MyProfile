package com.youngwoo.domain.repository

import com.youngwoo.domain.model.ProfileCardResult
import kotlinx.coroutines.flow.Flow

abstract class ProfileCardRepository {
    abstract suspend fun getAllMyPhotoCardList(): Flow<ProfileCardResult>
}