package com.example.testapp.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@SuppressLint("SuspiciousIndentation")
@Composable
fun CharactersView(viewModel: CharactersViewModel = hiltViewModel()) {
    val result = viewModel.characters.collectAsStateWithLifecycle()

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(result.value.results){ character ->
                    Column {
                        Text(character.name ?: "")
                        Text(text = character.gender ?: "")
                    }
                }
    }
}