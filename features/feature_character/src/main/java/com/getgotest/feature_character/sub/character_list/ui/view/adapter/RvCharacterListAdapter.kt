package com.getgotest.feature_character.sub.character_list.ui.view.adapter

import android.content.Context
import com.getgotest.component.base.BaseRecyclerViewAdapter
import com.getgotest.component.card.CharacterCard
import com.getgotest.service_character.domain.entity.ResultEntity

class RvCharacterListAdapter(
    private val context: Context,
    private val onItemClick: (Int) -> Unit
) : BaseRecyclerViewAdapter<ResultEntity, CharacterCard>() {

    override fun ViewHolder<CharacterCard>.onBind(item: ResultEntity, position: Int) {
        view.apply {
            name = item.name
            status = item.status
            species = item.species
        }
    }

    override fun generateView(viewType: Int): CharacterCard {
        return CharacterCard(context)
    }

    override fun onItemPressed(index: Int) {
        super.onItemPressed(index)
        onItemClick(index)
    }
}