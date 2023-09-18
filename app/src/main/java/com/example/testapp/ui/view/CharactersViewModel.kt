package com.example.testapp.ui.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    fun soSerious() {
        viewModelScope.launch {  }
    }

}