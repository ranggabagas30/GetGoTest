package com.getgotest.feature_character.sub.character_image.ui.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.getgotest.core.util.customSetImage
import com.getgotest.feature_character.databinding.ActivityCharacterImageBinding
import com.getgotest.feature_character.sub.character_image.ui.presenter.CharacterImageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterImageActivity : AppCompatActivity() {

    private var binding: ActivityCharacterImageBinding? = null
    private val characterImageViewModel: CharacterImageViewModel by viewModels()

    class Arguments(val image: String) {
        companion object {
            const val KEY_IMAGE = "key.image"

            fun createFromIntent(intent: Intent): Arguments {
                return Arguments(
                    intent.extras?.getString(KEY_IMAGE)?: ""
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterImageBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        getArguments()
        setObservers()
    }

    private fun getArguments() {
        characterImageViewModel.run {
            setImage(Arguments.createFromIntent(intent).image)
        }
    }

    private fun setObservers() {
        characterImageViewModel.run {
            image.observe(this@CharacterImageActivity) {
                binding?.ivImage?.apply {
                    customSetImage(it)
                }
            }
        }
    }
}