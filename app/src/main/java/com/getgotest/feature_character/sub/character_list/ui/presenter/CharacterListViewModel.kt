package com.getgotest.feature_character.sub.character_list.ui.presenter

import androidx.lifecycle.*
import com.getgotest.core.util.network.ResponseState
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

    private val _characterData: MutableLiveData<ResponseState<CharacterResponseEntity>> = MutableLiveData(ResponseState.Loading)
    val characterData: LiveData<ResponseState<CharacterResponseEntity>> = Transformations.map(_characterData) {
        it
    }

    fun getCharacter() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = getCharacterUseCase.run(Unit)
            withContext(Dispatchers.Main) {
                _characterData.value = response
            }
        }
    }
}