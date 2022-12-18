package com.getgotest.service_character.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterResponseEntity(
    val info: InfoEntity,
    val results: List<ResultEntity>
): Parcelable {
    companion object {
        val DEFAULT = CharacterResponseEntity(
            InfoEntity.DEFAULT,
            ResultEntity.DEFAULT_LIST
        )
    }
}