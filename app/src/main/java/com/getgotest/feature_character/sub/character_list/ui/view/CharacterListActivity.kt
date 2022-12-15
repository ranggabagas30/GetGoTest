package com.getgotest.feature_character.sub.character_list.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.getgotest.component.card.CharacterCard
import com.getgotest.component.util.recyclerview.ListUtil
import com.getgotest.databinding.ActivityCharacterListBinding
import com.getgotest.feature_character.sub.character_list.ui.presenter.CharacterListViewModel
import com.getgotest.feature_character.sub.character_list.ui.view.adapter.RvCharacterListAdapter
import dagger.hilt.android.AndroidEntryPoint
import org.w3c.dom.CharacterData

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {

    private var binding: ActivityCharacterListBinding? = null

    //private lateinit var characterData: List<CharacterCard.Data>
    private lateinit var rvCharacterListAdapter: RvCharacterListAdapter
    private val characterListViewModel: CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

//        characterData = listOf(
//            CharacterCard.Data(
//                "Tom",
//                "Live",
//                "Humanoid"
//            ),
//            CharacterCard.Data(
//                "Rangga",
//                "Live",
//                "Human"
//            ),
//            CharacterCard.Data(
//                "Urga",
//                "Dead",
//                "Animal"
//            )
//        )

        rvCharacterListAdapter = RvCharacterListAdapter(this) {
            // navigate to character detail page
        }

        initView()
        setObservers()
        requestData()
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

    private fun setObservers() {
        characterListViewModel.run {
            characterData.observe(this@CharacterListActivity) {
                hideLoading()
                binding?.apply {
                    rvCharacterListAdapter.submitList(
                        it.results.map {
                            CharacterCard.Data(
                                it.name,
                                it.status,
                                it.species
                            )
                        }
                    )
                }
            }
        }
    }

    private fun requestData() {
        characterListViewModel.run {
            showLoading()
            getCharacter()
        }
    }

    private fun showLoading() {
        binding?.apply {
            pbLoading.isVisible = true
            rvCharacterList.isVisible = false
        }
    }

    private fun hideLoading() {
        binding?.apply {
            pbLoading.isVisible = false
            rvCharacterList.isVisible = true
        }
    }
}