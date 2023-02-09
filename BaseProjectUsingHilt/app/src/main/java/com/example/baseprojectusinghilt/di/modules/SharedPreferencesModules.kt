package com.example.baseprojectusinghilt.di.modules


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.baseprojectusinghilt.utils.SpUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferencesModules {

     @Singleton
    @Provides
    fun providesSharedPreferences(context: Application): SharedPreferences {
        return context.getSharedPreferences("mode", Context.MODE_PRIVATE)
    }
    @Singleton
    @Provides
    fun providesSpUtil(sf: SharedPreferences): SpUtil {
        return SpUtil(sf)
    }
}