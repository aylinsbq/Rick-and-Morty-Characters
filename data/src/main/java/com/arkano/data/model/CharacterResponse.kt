package com.arkano.data.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val info: InfoDTO,
    val results: List<CharacterDTO>
)

@Serializable
data class InfoDTO(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)
