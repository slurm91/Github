package home.vzhilko.github.feature.auth.viewmodel

import android.annotation.SuppressLint
import android.net.Uri
import androidx.lifecycle.LiveData
import com.hadilq.liveevent.LiveEvent
import home.vzhilko.domain.extension.logDebug
import home.vzhilko.domain.feature.auth.interactor.AuthorizationInteractor
import home.vzhilko.github.App
import home.vzhilko.github.base.viewmodel.BaseViewModel
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(
    app: App,
    private val authorizationInteractor: AuthorizationInteractor
) : BaseViewModel(app) {

    private val authorizationLiveEvent: LiveEvent<Unit> = LiveEvent()
    val authorizationLiveData: LiveData<Unit> = authorizationLiveEvent

    @SuppressLint("CheckResult")
    fun authorize(redirectUri: Uri?) {
        addSubscriber(authorizationInteractor.authorize(redirectUri)
            .subscribe(
                { response -> authorizationLiveEvent.postValue(response) },
                { error -> "Not authorized, error message: ${error.message}".logDebug() }
            )
        )

    }

}