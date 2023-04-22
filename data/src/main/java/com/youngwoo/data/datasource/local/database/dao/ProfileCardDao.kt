package com.youngwoo.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.youngwoo.data.model.ProfileCardEntity

@Dao
interface ProfileCardDao {

    @Query("SELECT * FROM ${ProfileCardEntity.TABLE_NAME}")
    suspend fun getAllMyProfileCard(): List<ProfileCardEntity>
}