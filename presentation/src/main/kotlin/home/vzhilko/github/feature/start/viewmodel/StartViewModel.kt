package home.vzhilko.github.feature.start.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import home.vzhilko.github.App
import javax.inject.Inject

class StartViewModel @Inject constructor(app: App) : AndroidViewModel(app) {

    private val _authorizationStepTransitionLiveData: MutableLiveData<Unit?> = MutableLiveData()
    val authorizationStepTransitionLiveData: LiveData<Unit?> = _authorizationStepTransitionLiveData

    fun moveToAuthorizationStep() {
        _authorizationStepTransitionLiveData.value = Unit
        _authorizationStepTransitionLiveData.value = null
    }

}