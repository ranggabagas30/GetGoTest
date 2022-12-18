package com.getgotest.service_character.domain.repository

import com.getgotest.service_character.domain.entity.CharacterResponseEntity
import com.getgotest.service_character.domain.entity.EpisodeEntity

interface CharacterRepository {
    suspend fun getCharacter(): CharacterResponseEntity
    suspend fun getEpisode(id: Int): EpisodeEntity
}