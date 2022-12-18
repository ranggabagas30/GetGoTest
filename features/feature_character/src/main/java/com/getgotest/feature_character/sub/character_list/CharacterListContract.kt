package com.getgotest.feature_character.sub.character_list

import android.app.Activity
import com.getgotest.core.contract.RouterContract
import com.getgotest.service_character.domain.entity.ResultEntity

interface CharacterListContract {
    interface Router: RouterContract {
        fun navigateToChangeDetailPage(activity: Activity, resultEntity: ResultEntity)
    }
}