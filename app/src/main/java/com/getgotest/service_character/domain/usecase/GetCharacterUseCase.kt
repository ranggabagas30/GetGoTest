package com.getgotest.service_character.domain.usecase

import com.getgotest.service_character.domain.entity.CharacterResponseEntity
import com.getgotest.service_character.domain.repository.CharacterRepository

class GetCharacterUseCase(
    private val repository: CharacterRepository
) {
    suspend fun build(): CharacterResponseEntity {
        return repository.getCharacter()
    }
}