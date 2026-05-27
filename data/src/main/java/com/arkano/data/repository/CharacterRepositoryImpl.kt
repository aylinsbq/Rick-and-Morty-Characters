package com.arkano.data.repository

import com.arkano.data.api.RickAndMortyApi
import com.arkano.data.model.mapper.toDomain
import com.arkano.domain.model.Character
import com.arkano.domain.repository.CharacterRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
) : CharacterRepository {

    override suspend fun getCharacters(page: Int): Result<List<Character>> {
        return try {
            val response = api.getCharacters(page)
            val characters = response.results.map { it.toDomain() }
            Result.success(characters)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
