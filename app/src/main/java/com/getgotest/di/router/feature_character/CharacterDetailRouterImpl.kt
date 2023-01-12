package com.getgotest.di.router.feature_character

import android.app.Activity
import androidx.core.os.bundleOf
import com.getgotest.core.base.BaseRouter
import com.getgotest.feature_character.sub.character_detail.CharacterDetailContract
import com.getgotest.feature_character.sub.character_image.ui.view.CharacterImageActivity

class CharacterDetailRouterImpl : BaseRouter(), CharacterDetailContract.Router {
    override fun navigateToImageDetailPage(activity: Activity, image: String) {
        navigateTo(
            activity,
            CharacterImageActivity::class.java,
            bundleOf(
                CharacterImageActivity.Arguments.KEY_IMAGE to image
            )
        )
    }
}