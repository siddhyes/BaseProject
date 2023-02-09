package com.example.baseprojectusinghilt.di.modules

import android.content.Context
import androidx.room.Room
import com.example.baseprojectusinghilt.dataBase.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDataBase(@ApplicationContext context : Context) : AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "appDataBase").build()
    }
}