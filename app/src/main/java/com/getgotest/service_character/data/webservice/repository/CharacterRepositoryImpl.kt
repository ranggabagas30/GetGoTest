package com.getgotest.service_character.data.webservice.repository

import com.getgotest.service_character.data.webservice.mapper.CharacterResponseDtoMapper
import com.getgotest.service_character.data.webservice.service.CharacterApi
import com.getgotest.service_character.domain.entity.CharacterResponseEntity
import com.getgotest.service_character.domain.repository.CharacterRepository
import java.security.PrivateKey
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi,
    private val characterResponseDtoMapper: CharacterResponseDtoMapper
): CharacterRepository {
    override suspend fun getCharacter(): CharacterResponseEntity {
        return characterResponseDtoMapper(api.getCharacter())
    }
}