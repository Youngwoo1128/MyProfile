package com.youngwoo.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.youngwoo.data.model.PhotoCardEntity

@Dao
interface PhotoCardDao {

    @Query("SELECT * FROM ${PhotoCardEntity.TABLE_NAME}")
    suspend fun getAllMyPhotoCard(): List<PhotoCardEntity>
}