package com.getgotest.service_character.data.webservice.dto

import com.google.gson.annotations.SerializedName

data class LocationDetailDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("dimension") val dimension: String?,
)