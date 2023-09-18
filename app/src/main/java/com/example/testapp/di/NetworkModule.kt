package com.example.testapp.di

import com.example.testapp.data.client.RickAndMortyApi
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.create

class NetworkModule {

    fun provideGson() = Gson()

    fun provideRickAndMortyApi(retrofit: Retrofit): RickAndMortyApi {
        return retrofit.create()
    }


    companion object {

        private const val BASE_RICK_AND_MORTY_URL = "https://rickandmortyapi.com/api/"
    }
}
