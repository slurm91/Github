package home.vzhilko.github.feature.start.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.hadilq.liveevent.LiveEvent
import home.vzhilko.github.App

class StartViewModel constructor(app: App) : AndroidViewModel(app) {

    private val _authorizationStepTransitionLiveEvent: LiveEvent<Unit> = LiveEvent()
    val authorizationStepTransitionLiveData: LiveData<Unit> = _authorizationStepTransitionLiveEvent

    fun moveToAuthorizationStep() {
        _authorizationStepTransitionLiveEvent.value = Unit
    }

    private val _registrationStepTransitionLiveEvent: LiveEvent<Unit> = LiveEvent()
    val registrationStepTransitionLiveData: LiveData<Unit> = _registrationStepTransitionLiveEvent

    fun moveToRegistrationStep() {
        _registrationStepTransitionLiveEvent.value = Unit
    }

}