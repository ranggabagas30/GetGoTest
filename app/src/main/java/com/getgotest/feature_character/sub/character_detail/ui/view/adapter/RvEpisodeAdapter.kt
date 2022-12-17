package com.getgotest.feature_character.sub.character_detail.ui.view.adapter

import android.content.Context
import com.getgotest.component.base.BaseRecyclerViewAdapter
import com.getgotest.component.card.EpisodeCard

class RvEpisodeAdapter(
    private val context: Context
): BaseRecyclerViewAdapter<EpisodeCard.Data, EpisodeCard>() {
    override fun ViewHolder<EpisodeCard>.onBind(item: EpisodeCard.Data, position: Int) {
        view.apply {
            name = item.name
            airDate = item.airDate
            episode = item.episode
        }
    }

    override fun generateView(viewType: Int): EpisodeCard {
        return EpisodeCard(context)
    }
}