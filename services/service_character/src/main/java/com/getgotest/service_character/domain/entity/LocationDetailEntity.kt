package com.getgotest.service_character.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationDetailEntity(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
): Parcelable {
    companion object {
        val DEFAULT = LocationDetailEntity(
            0,
            "",
            "",
            ""
        )
    }
}