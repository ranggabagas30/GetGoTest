package com.getgotest.feature_character.sub.character_list.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.getgotest.component.util.recyclerview.ListUtil
import com.getgotest.core.base.ResponseState
import com.getgotest.databinding.ActivityCharacterListBinding
import com.getgotest.feature_character.sub.character_list.CharacterListContract
import com.getgotest.feature_character.sub.character_list.ui.presenter.CharacterListViewModel
import com.getgotest.feature_character.sub.character_list.ui.view.adapter.RvCharacterListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterListActivity : AppCompatActivity() {

    @Inject
    lateinit var router: CharacterListContract.Router

    private var binding: ActivityCharacterListBinding? = null
    private lateinit var rvCharacterListAdapter: RvCharacterListAdapter
    private val characterListViewModel: CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCharacterListBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        rvCharacterListAdapter = RvCharacterListAdapter(this) { index ->
            router.navigateToChangeDetailPage(this, rvCharacterListAdapter.currentList[index])
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
            characterData.observe(this@CharacterListActivity) { response ->
                Log.d(this@CharacterListActivity::class.java.simpleName, "response: $response")
                binding?.apply {
                    when (response) {
                        is ResponseState.Success -> {
                            hideLoading()
                            rvCharacterListAdapter.submitList(
                                response.data.results
                            )
                        }
                        is ResponseState.Failed -> {
                            hideLoading()
                            showError(response.message)
                        }
                        is ResponseState.Loading -> {
                            hideError()
                            showLoading()
                        }
                    }
                }
            }
        }
    }

    private fun requestData() {
        characterListViewModel.run {
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

    private fun showError(errorMessage: String) {
        binding?.apply {
            rvCharacterList.isVisible = false
            tvError.isVisible = true
            tvError.text = "Error: $errorMessage"
        }
    }

    private fun hideError() {
        binding?.apply {
            rvCharacterList.isVisible = true
            tvError.isVisible = false
        }
    }
}