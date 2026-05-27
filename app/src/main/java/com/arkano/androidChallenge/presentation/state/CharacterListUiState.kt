package com.arkano.androidChallenge.presentation.state

import com.arkano.domain.model.Character

sealed class CharacterListUiState {
    
    data object Loading : CharacterListUiState()
    
    data class Success(
        val characters: List<Character>,
        val currentPage: Int = 1,
        val hasNextPage: Boolean = false
    ) : CharacterListUiState()
    
    data class Error(
        val message: String,
        val canRetry: Boolean = true,
        val lastSuccessfulData: List<Character> = emptyList()
    ) : CharacterListUiState()
}
