package com.youngwoo.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.youngwoo.data.datasource.local.database.dao.PhotoCardDao
import com.youngwoo.data.model.PhotoCardEntity

@Database(
    entities = [PhotoCardEntity::class],
    version = 1,
    exportSchema = false
)

abstract class PhotoCardDatabase: RoomDatabase() {
    abstract fun photoCardDao(): PhotoCardDao

    companion object {
        const val DATABASE_NAME = "photocard.db"
    }
}