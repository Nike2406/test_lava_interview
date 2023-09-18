package com.example.testapp.data.client

import com.example.testapp.data.model.PoketmonModel
import com.example.testapp.data.model.RnMCharactersModel
import retrofit2.http.GET

interface PoketmonApi {

    @GET("pokemon/ditto")
    suspend fun getCharacters(): PoketmonModel
}

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters(): RnMCharactersModel
}