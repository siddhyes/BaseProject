package com.example.baseprojectusinghilt.di.modules

import android.util.Log
import androidx.viewbinding.BuildConfig
import com.example.api.retrofit.APIClient
import com.example.api.retrofit.APIClient2
import com.example.baseprojectusinghilt.utils.SpUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(okHttp: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp)
            // .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesAPIClient(retrofit: Retrofit): APIClient {
        return retrofit.create(APIClient::class.java)
    }

    @Singleton
    @Provides
    fun providesAPIClient2(retrofit: Retrofit): APIClient2 {
        return retrofit.create(APIClient2::class.java)
    }

    @Provides
    private fun okhttp(
        sharedPreferences: SpUtil,
    ): OkHttpClient {

        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY

            })
        if (BuildConfig.DEBUG) {
            /* builder.addNetworkInterceptor(StethoInterceptor())
             App.applicationContext().let { context ->
                 builder.addInterceptor(ChuckerInterceptor(context))
             }*/
        }

        val auth = sharedPreferences.getValueString( "AUTHORIZATION")?:""
        if (auth.isNotEmpty()) {
            builder.addInterceptor { chain ->
                var request = chain.request()
                val requestBuilder = request.newBuilder()
                //.header(AppENUM.AUTHORIZATION, String.format("%s %s", "Bearer", auth))
                // .header("Version", BuildConfig.VERSION_NAME)
                Log.e("Bearer", auth)
                request = requestBuilder.build()
                chain.proceed(request)
            }
        }
        return builder.build()
    }
}