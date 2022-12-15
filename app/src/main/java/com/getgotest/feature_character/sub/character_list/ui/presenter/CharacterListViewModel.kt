package com.getgotest.feature_character.sub.character_list.ui.presenter

import android.util.Log
import androidx.lifecycle.*
import com.getgotest.service_character.domain.entity.CharacterResponseEntity
import com.getgotest.service_character.domain.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase
): ViewModel() {

    private val _characterData = MutableLiveData(CharacterResponseEntity.DEFAULT)
    val characterData: LiveData<CharacterResponseEntity> = Transformations.map(_characterData) {
        it
    }

    fun getCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = kotlin.runCatching {
                getCharacterUseCase.build()
            }.getOrElse {
                Log.e(this@CharacterListViewModel::class.java.simpleName, "error -> $it")
                null
            }

            withContext(Dispatchers.Main) {
                response?.also {
                    _characterData.value = it
                }
            }
        }
    }
}