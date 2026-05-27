package com.arkano.domain.model

data class Character(
    val id: Int,
    val name: String,
    val status: CharacterStatus,
    val image: String
)

enum class CharacterStatus(val value: String) {
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("Unknown");
    companion object {
        fun fromValue(value: String): CharacterStatus {
            return entries.firstOrNull { it.value.equals(value, ignoreCase = true) }
                ?: UNKNOWN
        }
    }
}
