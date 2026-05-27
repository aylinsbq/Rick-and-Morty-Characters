package com.arkano.androidChallenge.presentation.viewmodel

import com.arkano.androidChallenge.presentation.state.CharacterListUiState
import com.arkano.domain.model.Character
import com.arkano.domain.model.CharacterStatus
import com.arkano.domain.usecase.GetCharactersUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CharacterListViewModelTest {

    private lateinit var getCharactersUseCase: GetCharactersUseCase
    private lateinit var viewModel: CharacterListViewModel
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        getCharactersUseCase = mockk()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `init should load characters and emit Success state`() = runTest {
        // Given
        val characters = listOf(
            Character(1, "Rick Sanchez", CharacterStatus.ALIVE, "image_url")
        )
        coEvery { getCharactersUseCase(1) } returns Result.success(characters)

        // When
        viewModel = CharacterListViewModel(getCharactersUseCase)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is CharacterListUiState.Success)
        assertEquals(characters, (state as CharacterListUiState.Success).characters)
    }

    @Test
    fun `loadCharacters failure should emit Error state`() = runTest {
        // Given
        val errorMessage = "Network Error"
        coEvery { getCharactersUseCase(1) } returns Result.failure(Exception(errorMessage))

        // When
        viewModel = CharacterListViewModel(getCharactersUseCase)

        // Then
        val state = viewModel.uiState.value
        assertTrue(state is CharacterListUiState.Error)
        assertEquals(errorMessage, (state as CharacterListUiState.Error).message)
    }
}
