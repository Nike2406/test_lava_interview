package com.example.testapp.data.repository

import com.example.testapp.data.client.PoketmonApi
import com.example.testapp.data.client.RickAndMortyApi
import com.example.testapp.data.model.PoketmonModel
import com.example.testapp.data.model.RnMCharactersModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val poketmonApi: PoketmonApi,
    private val rickAndMortyApi: RickAndMortyApi,
) {

    fun getPoketmons(): Flow<PoketmonModel> {
        return flow {
            val response = poketmonApi.getCharacters()

//            if (response.name.isNullOrEmpty()) {
//                throw RuntimeException()
//            }

            emit(response)
        }
    }

    fun getCharacters(): Flow<RnMCharactersModel> {
        return flow {
            val response = rickAndMortyApi.getCharacters()

//            if (response.name.isNullOrEmpty()) {
//                throw RuntimeException()
//            }

            emit(response)
        }
    }
}
