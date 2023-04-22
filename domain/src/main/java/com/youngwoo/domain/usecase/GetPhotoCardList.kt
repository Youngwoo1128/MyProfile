package com.youngwoo.domain.usecase

import com.youngwoo.domain.repository.ProfileCardRepository
import javax.inject.Inject

class GetPhotoCardList @Inject constructor(
    private val profileCardRepository: ProfileCardRepository
) {
    suspend operator fun invoke() = profileCardRepository.getAllMyPhotoCardList()
}