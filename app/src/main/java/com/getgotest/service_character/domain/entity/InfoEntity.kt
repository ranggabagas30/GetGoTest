package com.getgotest.service_character.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfoEntity(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String
): Parcelable {
    companion object {
        val DEFAULT = InfoEntity(0, 0, "", "")
    }
}