package com.getgotest.feature_character.sub.character_detail.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.getgotest.databinding.ActivityCharacterDetailBinding

class CharacterDetailActivity : AppCompatActivity() {

    private var binding: ActivityCharacterDetailBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    private fun initView() {

    }
}