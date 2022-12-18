package com.getgotest.feature_character.sub.character_detail.ui.view.adapter

import android.content.Context
import android.util.Log
import com.getgotest.component.base.BaseRecyclerViewAdapter
import com.getgotest.component.card.EpisodeCard
import com.getgotest.service_character.domain.entity.EpisodeEntity

class RvEpisodeAdapter(
    private val context: Context
): BaseRecyclerViewAdapter<EpisodeEntity, EpisodeCard>() {
    override fun ViewHolder<EpisodeCard>.onBind(item: EpisodeEntity, position: Int) {
        view.apply {
            name = item.name
            airDate = item.airDate
            episode = item.episode
        }
    }

    override fun generateView(viewType: Int): EpisodeCard {
        Log.d(this::class.java.simpleName, "generateView")
        return EpisodeCard(context)
    }
}