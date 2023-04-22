package com.youngwoo.data.repositoryImpl

import com.youngwoo.data.datasource.local.datasource.ProfileCardDataSource
import com.youngwoo.data.mapping.toDomain
import com.youngwoo.domain.model.ProfileCardResult
import com.youngwoo.domain.repository.ProfileCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProfileCardRepositoryImpl @Inject constructor(
    private val profileCardDataSource: ProfileCardDataSource
) : ProfileCardRepository() {

    override suspend fun getAllMyPhotoCardList(): Flow<ProfileCardResult> {
        return flow {
            val allMyPhotoCard = profileCardDataSource.getAllMyProfileCard().toDomain()
            val result = ProfileCardResult.Success(allMyPhotoCard)

            allMyPhotoCard.takeIf { it.isEmpty() }?.run {
                emit(ProfileCardResult.NonProfileCard)
            }?: kotlin.run {
                emit(result)
            }

        }.catch { exception ->
            val exceptionResult = ProfileCardResult.Fail(exception)
            emit(exceptionResult)
        }
    }
}