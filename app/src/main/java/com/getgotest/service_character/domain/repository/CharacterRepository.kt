package com.getgotest.service_character.domain.repository

import com.getgotest.service_character.domain.entity.CharacterResponseEntity

interface CharacterRepository {
    suspend fun getCharacter(): CharacterResponseEntity
}