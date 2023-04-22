package com.youngwoo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.youngwoo.data.model.ProfileCardEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ProfileCardEntity(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "greetingMessage") val greetingMessage: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "skills") val skills: String
) {
    companion object {
        const val TABLE_NAME = "photocard"
    }
}
