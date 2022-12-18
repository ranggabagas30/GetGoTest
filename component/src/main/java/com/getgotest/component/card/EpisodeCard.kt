package com.getgotest.component.card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.getgotest.component.R
import com.getgotest.component.databinding.ItemEpisodeBinding

class EpisodeCard(context: Context, attributeSet: AttributeSet? = null): FrameLayout(context, attributeSet) {

    private val binding = ItemEpisodeBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    data class Data(
        var name: String,
        var airDate: String,
        var episode: String
    )

    var name: String = ""
        set(value) {
            field = value
            refreshView()
        }

    var airDate: String = ""
        set(value) {
            field = value
            refreshView()
        }

    var episode: String = ""
        set(value) {
            field = value
            refreshView()
        }

    var isLoading: Boolean = false
        set(value) {
            field = value
            refreshView()
        }

    init {
        parent.apply {
            setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))
        }
    }

    private fun refreshView() {
        binding.apply {
            tvName.text = name
            tvAirDate.text = airDate
            tvEpisode.text = episode
            pbLoading.isVisible = isLoading
        }
    }
}