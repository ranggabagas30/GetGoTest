package com.getgotest.feature_character.sub.character_detail.ui.presenter

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.getgotest.core.base.ResponseState
import com.getgotest.core.util.add
import com.getgotest.service_character.domain.entity.EpisodeEntity
import com.getgotest.service_character.domain.entity.LocationDetailEntity
import com.getgotest.service_character.domain.entity.ResultEntity
import com.getgotest.service_character.domain.usecase.GetEpisodeUseCase
import com.getgotest.service_character.domain.usecase.GetLocationDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getEpisodeUseCase: GetEpisodeUseCase,
    private val getLocationDetailUseCase: GetLocationDetailUseCase
): ViewModel() {

    val characterDetail: MutableLiveData<ResultEntity?> = MutableLiveData(null)
    val episodeDetailList: MutableLiveData<MutableList<EpisodeEntity>> = MutableLiveData(mutableListOf())

    fun getAllEpisodeDetail(episodeList: List<String>) {
        viewModelScope.launch(Dispatchers.IO) {
            episodeList.asFlow().collect {
                val id = (Uri.parse(it).lastPathSegment?: "1").toInt()
                val response = getEpisodeUseCase.run(id)
                withContext(Dispatchers.Main) {
                    if (response is ResponseState.Success) {
                        episodeDetailList.add(response.data)
                    }
                }
            }
        }
    }

    fun getLocationDetail(url: String, onComplete: (LocationDetailEntity) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val id = (Uri.parse(url).lastPathSegment?: "1").toInt()
            val response = getLocationDetailUseCase.run(id)
            withContext(Dispatchers.Main) {
                if (response is ResponseState.Success) {
                    onComplete(response.data)
                }
            }
        }
    }
}