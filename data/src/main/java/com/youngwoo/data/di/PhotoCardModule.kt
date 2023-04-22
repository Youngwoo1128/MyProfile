package com.youngwoo.data.di

import android.content.Context
import androidx.room.Room
import com.youngwoo.data.datasource.local.database.ProfileCardDatabase
import com.youngwoo.data.datasource.local.database.dao.ProfileCardDao
import com.youngwoo.data.datasource.local.datasource.ProfileCardDataSource
import com.youngwoo.data.datasource.local.datasource.ProfileCardDataSourceImpl
import com.youngwoo.data.repositoryImpl.ProfileCardRepositoryImpl
import com.youngwoo.domain.repository.ProfileCardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PhotoCardModule {

    @Singleton
    @Provides
    fun providePhotoCardDataBase(
        @ApplicationContext context: Context
    ): ProfileCardDatabase = Room
        .databaseBuilder(context, ProfileCardDatabase::class.java, ProfileCardDatabase.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Singleton
    @Provides
    fun providePhotoCardDao(profileCardDatabase: ProfileCardDatabase): ProfileCardDao = profileCardDatabase.profileCardDao()

    @Provides
    @Singleton
    fun providePhotoCardDataSource(
        photoCardDao: ProfileCardDao
    ): ProfileCardDataSource = ProfileCardDataSourceImpl(photoCardDao)

    @Provides
    @Singleton
    fun providePhotoCardRepository(
        profileCardDataSource: ProfileCardDataSource
    ): ProfileCardRepository = ProfileCardRepositoryImpl(profileCardDataSource)

}