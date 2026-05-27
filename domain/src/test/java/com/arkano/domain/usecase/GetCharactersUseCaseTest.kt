package com.arkano.domain.usecase

import com.arkano.domain.model.Character
import com.arkano.domain.model.CharacterStatus
import com.arkano.domain.repository.CharacterRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetCharactersUseCaseTest {

    private lateinit var repository: CharacterRepository
    private lateinit var getCharactersUseCase: GetCharactersUseCase

    @Before
    fun setUp() {
        repository = mockk()
        getCharactersUseCase = GetCharactersUseCase(repository)
    }

    @Test
    fun `invoke should return success when repository returns success`() = runTest {
        // Given
        val characters = listOf(
            Character(1, "Rick Sanchez", CharacterStatus.ALIVE, "image_url"),
            Character(2, "Morty Smith", CharacterStatus.ALIVE, "image_url")
        )
        coEvery { repository.getCharacters(1) } returns Result.success(characters)

        // When
        val result = getCharactersUseCase(1)

        // Then
        assertTrue(result.isSuccess)
        assertEquals(characters, result.getOrNull())
    }

    @Test
    fun `invoke should return failure when repository returns failure`() = runTest {
        // Given
        val exception = Exception("Network Error")
        coEvery { repository.getCharacters(1) } returns Result.failure(exception)

        // When
        val result = getCharactersUseCase(1)

        // Then
        assertTrue(result.isFailure)
        assertEquals(exception, result.exceptionOrNull())
    }
}
