package com.example.practicaclima.di

import com.example.practicaclima.data.dataClimaActual.network.ClimaActualAPI
import com.example.practicaclima.data.dataPronostico.network.PronosticoAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ClimaActualNetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit):ClimaActualAPI{
        return retrofit.create(ClimaActualAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideAPIPronosClient(retrofit2: Retrofit):PronosticoAPI{
        return retrofit2.create(PronosticoAPI::class.java)
    }

}