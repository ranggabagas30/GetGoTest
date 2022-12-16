package com.getgotest.service_character.domain.usecase

import com.getgotest.core.base.BaseUseCase
import com.getgotest.service_character.domain.entity.CharacterResponseEntity
import com.getgotest.service_character.domain.repository.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
): BaseUseCase<Unit, CharacterResponseEntity>() {
    override suspend fun build(param: Unit): CharacterResponseEntity {
        return repository.getCharacter()
    }
}