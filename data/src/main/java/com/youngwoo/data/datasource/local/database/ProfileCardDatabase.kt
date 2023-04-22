package com.youngwoo.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.youngwoo.data.datasource.local.database.dao.ProfileCardDao
import com.youngwoo.data.model.ProfileCardEntity

@Database(
    entities = [ProfileCardEntity::class],
    version = 1,
    exportSchema = false
)

abstract class ProfileCardDatabase: RoomDatabase() {
    abstract fun profileCardDao(): ProfileCardDao

    companion object {
        const val DATABASE_NAME = "profileCard.db"
    }
}