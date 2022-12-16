package com.getgotest.service_character.data.webservice.dto

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class ResultDto(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("species") val species: String?,
    @SerializedName("gender") val gender: String?,
    @SerializedName("origin") val origin: Location?,
    @SerializedName("location") val location: Location?,
    @SerializedName("image") val image: String?,
    @SerializedName("episodes") val episodes: List<String>?
) {
    @Parcelize
    data class Location(
        @SerializedName("name") val name: String?,
        @SerializedName("url") val url: String?
    ): Parcelable

}