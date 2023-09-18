package com.example.testapp.di

import com.example.testapp.data.client.PoketmonApi
import com.example.testapp.data.client.RickAndMortyApi
import com.example.testapp.data.client.intrceptor.LoggingInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson() = Gson()

    @Singleton
    @Provides
    fun provideClient(loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_RICK_AND_MORTY_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun providePoketmonApi(retrofit: Retrofit): PoketmonApi {
        return retrofit.create()
    }

    @Singleton
    @Provides
    fun provideRickAndMortyApi(retrofit: Retrofit): RickAndMortyApi {
        return retrofit.create()
    }


    companion object {

        private const val BASE_POCKETMON_URL = "https://pokeapi.co/api/v2/"
        private const val BASE_RICK_AND_MORTY_URL = "https://rickandmortyapi.com/api/"
    }
}