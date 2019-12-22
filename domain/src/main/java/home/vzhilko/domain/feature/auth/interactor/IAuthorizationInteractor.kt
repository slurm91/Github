package home.vzhilko.domain.feature.auth.interactor

import android.net.Uri
import home.vzhilko.domain.base.interactor.ReactiveInteractorWithCallback

interface IAuthorizationInteractor : ReactiveInteractorWithCallback<IAuthorizationInteractor.AuthorizationInteractorCallback> {

    fun authorize(redirectUri: Uri?)

    interface AuthorizationInteractorCallback {

        fun handleSuccessfulAuthorization()

    }

}