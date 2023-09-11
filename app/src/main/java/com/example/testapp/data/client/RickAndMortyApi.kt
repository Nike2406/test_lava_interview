package com.example.testapp.data.client

import com.example.testapp.data.model.CharactersModel
import retrofit2.http.GET
import retrofit2.http.POST

interface RickAndMortyApi {

    @GET("pokemon/ditto")
    suspend fun getCharacters(): CharactersModel
}