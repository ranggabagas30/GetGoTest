package com.getgotest.service_character.data.webservice.dto

import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("air_date") val airDate: String?,
    @SerializedName("episode") val episode: String?,
    @SerializedName("characters") val characters: List<String>?
) {
}