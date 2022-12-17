package com.getgotest.feature_character.sub.character_detail.ui.presenter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.getgotest.service_character.domain.entity.ResultEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(): ViewModel() {

    val characterDetail: MutableLiveData<ResultEntity?> = MutableLiveData(null)

}