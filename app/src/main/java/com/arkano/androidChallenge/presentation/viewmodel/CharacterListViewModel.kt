package com.arkano.androidChallenge.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arkano.androidChallenge.presentation.state.CharacterListUiState
import com.arkano.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<CharacterListUiState>(CharacterListUiState.Loading)
    val uiState: StateFlow<CharacterListUiState> = _uiState.asStateFlow()

    init {
        loadCharacters()
    }

    fun loadCharacters(page: Int = 1) {
        viewModelScope.launch {
            _uiState.value = CharacterListUiState.Loading
            
            getCharactersUseCase(page).fold(
                onSuccess = { characters ->
                    _uiState.value = CharacterListUiState.Success(
                        characters = characters,
                        currentPage = page,
                        hasNextPage = page < 42
                    )
                },
                onFailure = { error ->
                    _uiState.value = CharacterListUiState.Error(
                        message = error.message ?: "Unknown error"
                    )
                }
            )
        }
    }
}
