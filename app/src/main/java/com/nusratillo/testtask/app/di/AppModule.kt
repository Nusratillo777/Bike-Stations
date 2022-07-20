package com.nusratillo.testtask.app.di

import com.nusratillo.testtask.data.rest.BikeStationsService
import com.nusratillo.testtask.data.rest.ServerUrls
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(ServerUrls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
    }
    single<BikeStationsService> {
        get<Retrofit>().create(BikeStationsService::class.java)
    }
}

val appModules = listOf(
    appModule,
    repositoryModule,
    viewModelModule
)