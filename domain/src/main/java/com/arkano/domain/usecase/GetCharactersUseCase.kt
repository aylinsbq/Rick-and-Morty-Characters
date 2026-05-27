package com.arkano.domain.usecase

import com.arkano.domain.model.Character
import com.arkano.domain.repository.CharacterRepository
import javax.inject.Inject

/**
 * Use case to obtain the character list
 */
class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(page: Int = 1): Result<List<Character>> {
        return repository.getCharacters(page)
    }
}
