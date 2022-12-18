package com.getgotest.service_character.data.webservice.service

import com.getgotest.service_character.data.webservice.dto.CharacterResponseDto
import com.getgotest.service_character.data.webservice.dto.EpisodeDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApi {
    @GET("character")
    suspend fun getCharacter(): CharacterResponseDto

    @GET("episode/{id}")
    suspend fun getEpisode(
        @Path("id") id: Int
    ): EpisodeDto
}