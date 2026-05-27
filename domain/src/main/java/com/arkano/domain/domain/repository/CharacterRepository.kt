package com.arkano.domain.domain.repository

import com.arkano.domain.domain.model.Character

interface CharacterRepository {
    /**
     * Gets a paginated list of characters.
     */
    suspend fun getCharacters(page: Int = 1): Result<List<Character>>
}
