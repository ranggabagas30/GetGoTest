package com.getgotest.service_character.data.webservice.dto
import com.google.gson.annotations.SerializedName

data class CharacterResponseDto(
    @SerializedName("info") val info: com.getgotest.service_character.data.webservice.dto.InfoDto,
    @SerializedName("results") val results: List<com.getgotest.service_character.data.webservice.dto.ResultDto>
)