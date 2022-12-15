package com.getgotest.feature_character.sub.character_list.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.getgotest.component.card.CharacterCard
import com.getgotest.component.util.recyclerview.ListUtil
import com.getgotest.databinding.ActivityCharacterListBinding
import com.getgotest.feature_character.sub.character_list.ui.view.adapter.RvCharacterListAdapter

class CharacterListActivity : AppCompatActivity() {

    private lateinit var characterData: List<CharacterCard.Data>
    private lateinit var rvCharacterListAdapter: RvCharacterListAdapter
    private var binding: ActivityCharacterListBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        characterData = listOf(
            CharacterCard.Data(
                "Tom",
                "Live",
                "Humanoid"
            ),
            CharacterCard.Data(
                "Rangga",
                "Live",
                "Human"
            ),
            CharacterCard.Data(
                "Urga",
                "Dead",
                "Animal"
            )
        )

        rvCharacterListAdapter = RvCharacterListAdapter(this) {
            // navigate to character detail page
        }
        rvCharacterListAdapter.apply {
            submitList(characterData)
        }

        initView()
    }

    private fun initView() {
        binding?.apply {
            rvCharacterList.apply {
                adapter = rvCharacterListAdapter
                addItemDecoration(
                    ListUtil.getListGapDecorator(
                        this@CharacterListActivity,
                        2
                    )
                )
            }
        }
    }
}