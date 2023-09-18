package com.example.testapp.ui.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.model.PoketmonModel
import com.example.testapp.data.model.RnMCharactersModel
import com.example.testapp.data.repository.CharactersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val charactersRepository: CharactersRepository
) : ViewModel() {

    private var _poketmons = MutableStateFlow<PoketmonModel>(PoketmonModel())
    val poketmons = _poketmons.asStateFlow()

    private var _characters = MutableStateFlow(RnMCharactersModel())
    val characters = _characters.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
//            setPoketmons()
            setCharacters()
        }
    }

    private suspend fun setPoketmons() {
        charactersRepository.getPoketmons()
            .catch {
                Log.e("FUCK", "viewModel error: ${it.message}")
            }
            .collectLatest {
                _poketmons.emit(it)
            }
    }

    private suspend fun setCharacters() {
        charactersRepository.getCharacters()
            .catch {
                Log.e("FUCK", "viewModel error: ${it.message}")
            }
            .collectLatest {
                _characters.emit(it)
            }
    }
}