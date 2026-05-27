package com.arkano.domain.repository

import com.arkano.domain.model.Character

interface CharacterRepository {
    /**
     * Gets a paginated list of characters.
     */
    suspend fun getCharacters(page: Int = 1): Result<List<Character>>
}