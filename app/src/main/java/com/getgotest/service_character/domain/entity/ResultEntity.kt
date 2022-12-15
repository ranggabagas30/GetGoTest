package com.getgotest.service_character.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultEntity(
    val id: Int,
    val name: String,
    val status: String,
    val species: String
): Parcelable {
    companion object {
        val DEFAULT = ResultEntity(
            0,
            "",
            "",
            ""
        )
        val DEFAULT_LIST = emptyList<ResultEntity>()
    }
}