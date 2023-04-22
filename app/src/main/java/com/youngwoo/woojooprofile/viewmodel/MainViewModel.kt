package com.youngwoo.woojooprofile.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.youngwoo.domain.model.ProfileCardResult
import com.youngwoo.domain.usecase.GetPhotoCardList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPhotoCardList: GetPhotoCardList
): ViewModel() {

    private val _profileCards = MutableSharedFlow<ProfileCardResult>()
    val profileCards: SharedFlow<ProfileCardResult>
        get() = _profileCards

    fun getMyPhotoCardList() {
        viewModelScope.launch {
            getPhotoCardList().collectLatest {
                _profileCards.emit(it)
            }
        }
    }
}