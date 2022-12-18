package com.getgotest.service_character.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeEntity(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>
): Parcelable {
    companion object {
        val DEFAULT = EpisodeEntity(
            0,
            "",
            "",
            "",
            emptyList()
        )
    }
}