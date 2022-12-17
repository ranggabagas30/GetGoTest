package com.getgotest.feature_character.sub.character_detail.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.getgotest.component.card.EpisodeCard
import com.getgotest.component.util.recyclerview.ListUtil
import com.getgotest.core.util.customSetImage
import com.getgotest.databinding.ActivityCharacterDetailBinding
import com.getgotest.feature_character.sub.character_detail.ui.presenter.CharacterDetailViewModel
import com.getgotest.feature_character.sub.character_detail.ui.view.adapter.RvEpisodeAdapter
import com.getgotest.service_character.domain.entity.ResultEntity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailActivity : AppCompatActivity() {

    private var binding: ActivityCharacterDetailBinding? = null
    private val characterDetailViewModel: CharacterDetailViewModel by viewModels()
    private lateinit var rvEpisodeAdapter: RvEpisodeAdapter

    class Arguments(val characterDetail: ResultEntity?) {
        companion object {
            val KEY_CHARACTER_SELECTED = "key.character.selected"

            fun createFromIntent(intent: Intent): Arguments {
                return Arguments(
                    intent.extras?.getParcelable(KEY_CHARACTER_SELECTED)
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        getArguments()
        initView()
        setObservers()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getArguments() {
        characterDetailViewModel.run {
            characterDetail.value = Arguments.createFromIntent(intent).characterDetail
        }
    }

    private fun initView() {
        binding?.apply {
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
            }
            rvEpisodeAdapter = RvEpisodeAdapter(this@CharacterDetailActivity)
            rvEpisodes.apply {
                adapter = rvEpisodeAdapter
                addItemDecoration(
                    ListUtil.getListGapDecorator(
                        this@CharacterDetailActivity,
                        5
                    )
                )
            }
        }
    }

    private fun setObservers() {
        characterDetailViewModel.run {
            characterDetail.observe(this@CharacterDetailActivity) { characterDetail ->
                characterDetail?.let {
                    binding?.apply {
                        ivImage.customSetImage(it.image)
                        tvGender.text = "Gender: ${it.gender}"
                        tvOrigin.text = "Origin: ${it.origin.name}"
                        tvLocation.text = "Location: ${it.location.name}"
                    }
                    rvEpisodeAdapter.submitList(
                        it.episode.map {
                            EpisodeCard.Data(
                                it,
                                "",
                                ""
                            )
                        }
                    )
                }
            }
        }
    }
}