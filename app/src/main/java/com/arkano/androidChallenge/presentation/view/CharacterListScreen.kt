package com.arkano.androidChallenge.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.arkano.androidChallenge.presentation.component.CharacterItem
import com.arkano.androidChallenge.presentation.component.ErrorState
import com.arkano.androidChallenge.presentation.component.LoadingState
import com.arkano.androidChallenge.presentation.state.CharacterListUiState
import com.arkano.androidChallenge.presentation.viewmodel.CharacterListViewModel
import com.arkano.domain.model.Character

@Composable
fun CharacterListScreen(
    modifier: Modifier = Modifier,
    viewModel: CharacterListViewModel = hiltViewModel<CharacterListViewModel>()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        when (val state = uiState) {
            is CharacterListUiState.Loading -> {
                LoadingState()
            }

            is CharacterListUiState.Success -> {
                CharacterList(characters = state.characters)
            }

            is CharacterListUiState.Error -> {
                ErrorState(
                    message = state.message,
                    onRetry = { viewModel.loadCharacters() }
                )
            }
        }
    }

}

@Composable
fun CharacterList(
    characters: List<Character>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(
            items = characters,
            key = { it.id }
        ) { character ->
            CharacterItem(character = character)
        }
    }
}
