package home.vzhilko.start.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.hadilq.liveevent.LiveEvent
import home.vzhilko.core.presentation.viewmodel.BaseViewModel

class StartViewModel constructor(application: Application) : BaseViewModel(application) {

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