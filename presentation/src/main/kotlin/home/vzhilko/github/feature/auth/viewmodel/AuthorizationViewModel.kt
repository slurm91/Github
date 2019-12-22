package home.vzhilko.github.feature.auth.viewmodel

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import home.vzhilko.domain.feature.auth.interactor.IAuthorizationInteractor
import home.vzhilko.github.App
import home.vzhilko.github.base.viewmodel.BaseViewModel
import javax.inject.Inject

class AuthorizationViewModel @Inject constructor(
    app: App,
    private val authorizationInteractor: IAuthorizationInteractor
) : BaseViewModel(app, authorizationInteractor), IAuthorizationInteractor.AuthorizationInteractorCallback {

    val authorizationLiveData: MutableLiveData<Unit?> = MutableLiveData()

    init {
        authorizationInteractor.callback = this
    }

    fun authorize(redirectUri: Uri?) {
        authorizationInteractor.authorize(redirectUri)
    }

    override fun handleSuccessfulAuthorization() {
        authorizationLiveData.value = Unit
    }

}