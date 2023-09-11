package com.example.testapp.ui.view

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.data.model.CharactersModel
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

    private var _characters = MutableStateFlow<CharactersModel>(CharactersModel())
    val characters = _characters.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            setCharacters()
        }
    }

    private suspend fun setCharacters() {
        charactersRepository.getCharacters()
            .catch {
                Log.e("FUCK", "Error!")
            }
            .collectLatest {
                _characters.emit(it)
            }
    }
}