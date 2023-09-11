package com.example.testapp.ui.view

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

@Composable
fun CharactersView(viewModel: CharactersViewModel = hiltViewModel()) {
    val character = viewModel.characters.collectAsStateWithLifecycle()

            Row(modifier = Modifier.fillMaxWidth()) {
                Column{
                    Text(character.value.name ?: "")
                    Text(text = character.value.locationAreaEncounters ?: "1")
                }
    }
}