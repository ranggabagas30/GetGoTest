package com.getgotest.service_character.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultEntity(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Location,
    val location: Location,
    val image: String,
    val episode: List<String>
): Parcelable {
    companion object {
        val DEFAULT = ResultEntity(
            0,
            "",
            "",
            "",
            "",
            Location.DEFAULT,
            Location.DEFAULT,
            "",
            emptyList()
        )
        val DEFAULT_LIST = emptyList<ResultEntity>()
    }

    @Parcelize
    data class Location(
        val name: String,
        val url: String
    ): Parcelable {
        companion object {
            val DEFAULT = Location("", "")
        }
    }
}