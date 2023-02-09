package com.example.baseprojectusinghilt.di.modules

import com.example.api.retrofit.APIClient
import com.example.baseprojectusinghilt.dataBase.AppDataBase
import com.example.baseprojectusinghilt.repo.Repo1
import com.example.baseprojectusinghilt.utils.SpUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@InstallIn(ActivityComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun providesRepo1(dataBase: AppDataBase, apiClient: APIClient, sf: SpUtil): Repo1 {
        return Repo1(dataBase, apiClient, sf)
    }
}