package com.getgotest.service_character.data.webservice.dto

import com.google.gson.annotations.SerializedName

class ResultDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("species") val species: String?
)