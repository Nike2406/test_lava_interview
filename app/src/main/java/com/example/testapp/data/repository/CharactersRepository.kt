package com.example.testapp.data.repository

import com.example.testapp.data.client.RickAndMortyApi
import com.example.testapp.data.model.CharactersModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: RickAndMortyApi,
) {

    fun getCharacters(): Flow<CharactersModel> {
        return flow {
            val response = api.getCharacters()

//            if (response.name.isNullOrEmpty()) {
//                throw RuntimeException()
//            }

            emit(response)
        }
    }
}
