package com.getgotest.component.card

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.getgotest.component.R
import com.getgotest.component.databinding.ItemCharacterBinding

class CharacterCard(context: Context, attributeSet: AttributeSet? = null): FrameLayout(context, attributeSet) {

    private val binding = ItemCharacterBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    data class Data(
        var name: String,
        var status: String,
        var species: String
    )

    var name: String = ""
        set(value) {
            field = value
            refreshView()
        }

    var status: String = ""
        set(value) {
            field = value
            refreshView()
        }

    var species: String = ""
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
            tvStatus.text = status
            tvSpecies.text = species
        }
    }
}