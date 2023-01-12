package com.getgotest.feature_character.sub.character_image.ui.presenter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterImageViewModel @Inject constructor() : ViewModel() {

    private val _image: MutableLiveData<String> = MutableLiveData("")
    val image: LiveData<String> = Transformations.map(_image) {
        it
    }

    fun setImage(image: String) {
        _image.value = image
    }


}