package com.getgotest.di.router.feature_character

import android.app.Activity
import androidx.core.os.bundleOf
import com.getgotest.feature_character.sub.character_list.CharacterListContract
import com.getgotest.core.base.BaseRouter
import com.getgotest.feature_character.sub.character_detail.ui.view.CharacterDetailActivity
import com.getgotest.service_character.domain.entity.ResultEntity

class CharacterListRouterImpl: BaseRouter(), CharacterListContract.Router {
    override fun navigateToChangeDetailPage(activity: Activity, resultEntity: ResultEntity) {
        navigateTo(
            activity,
            CharacterDetailActivity::class.java,
            bundleOf(
                CharacterDetailActivity.Arguments.KEY_CHARACTER_SELECTED to resultEntity
            )
        )
    }
}