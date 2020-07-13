package home.vzhilko.auth.presentation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.net.Uri
import androidx.lifecycle.LiveData
import com.hadilq.liveevent.LiveEvent
import home.vzhilko.auth.domain.interactor.AuthorizationInteractor
import home.vzhilko.core.base.extension.logDebug
import home.vzhilko.core.presentation.viewmodel.BaseViewModel

class AuthorizationViewModel constructor(
    application: Application,
    private val authorizationInteractor: AuthorizationInteractor
) : BaseViewModel(application) {

    private val authorizationLiveEvent: LiveEvent<Unit> = LiveEvent()
    val authorizationLiveData: LiveData<Unit> = authorizationLiveEvent

    @SuppressLint("CheckResult")
    fun authorize(redirectUri: Uri?) {
        addSubscriber(authorizationInteractor.authorize(redirectUri)
            .doOnSubscribe { progressLiveData.postValue(true) }
            .subscribe(
                { response ->
                    progressLiveData.postValue(false)
                    authorizationLiveEvent.postValue(response)
                },
                { error ->
                    progressLiveData.postValue(false)
                    "Not authorized, error message: ${error.message}".logDebug()
                }
            )
        )

    }

}