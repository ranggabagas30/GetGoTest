package com.getgotest.service_character.data.webservice.service

import com.getgotest.service_character.data.webservice.dto.CharacterResponseDto
import com.getgotest.service_character.data.webservice.mapper.CharacterResponseDtoMapper
import retrofit2.http.GET

interface CharacterApi {
    @GET("character")
    suspend fun getCharacter(): CharacterResponseDto
}