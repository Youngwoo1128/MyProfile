package com.youngwoo.data.datasource.local.datasource

import com.youngwoo.data.datasource.local.database.dao.ProfileCardDao
import com.youngwoo.data.model.ProfileCardEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProfileCardDataSourceImpl @Inject constructor(
    private val photoCardDao: ProfileCardDao
): ProfileCardDataSource {

    override suspend fun getAllMyProfileCard(): List<ProfileCardEntity> = withContext(Dispatchers.IO) {
        photoCardDao.getAllMyProfileCard()
    }
}