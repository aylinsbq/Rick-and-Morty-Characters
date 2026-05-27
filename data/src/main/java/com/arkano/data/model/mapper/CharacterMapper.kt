package com.arkano.data.model.mapper

import com.arkano.data.model.CharacterDTO
import com.arkano.domain.model.Character
import com.arkano.domain.model.CharacterStatus

/**
 * Maps a [CharacterDTO] (Data Layer) and a [Character] (Domain Layer).
 * Here we filter only the fields that the business logic and UI need.
 */
fun CharacterDTO.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        status = CharacterStatus.fromValue(status),
        image = this.image
    )
}
