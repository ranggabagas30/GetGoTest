package com.getgotest.service_character.data.webservice.repository

import com.getgotest.service_character.data.webservice.mapper.CharacterResponseDtoMapper
import com.getgotest.service_character.data.webservice.mapper.EpisodeDtoMapper
import com.getgotest.service_character.data.webservice.service.CharacterApi
import com.getgotest.service_character.domain.entity.CharacterResponseEntity
import com.getgotest.service_character.domain.entity.EpisodeEntity
import com.getgotest.service_character.domain.repository.CharacterRepository
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val api: CharacterApi,
    private val characterResponseDtoMapper: CharacterResponseDtoMapper,
    private val episodeDtoMapper: EpisodeDtoMapper
): CharacterRepository {
    override suspend fun getCharacter(): CharacterResponseEntity {
        return characterResponseDtoMapper(api.getCharacter())
    }

    override suspend fun getEpisode(id: Int): EpisodeEntity {
        return episodeDtoMapper(api.getEpisode(id))
    }
}