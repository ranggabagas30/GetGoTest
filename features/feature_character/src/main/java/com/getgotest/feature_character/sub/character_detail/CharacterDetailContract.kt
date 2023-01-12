package com.getgotest.feature_character.sub.character_detail

import android.app.Activity
import com.getgotest.core.contract.RouterContract

interface CharacterDetailContract {
    interface Router: RouterContract {
        fun navigateToImageDetailPage(activity: Activity, image: String)
    }
}