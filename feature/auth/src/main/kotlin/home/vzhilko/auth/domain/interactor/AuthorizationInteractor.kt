package home.vzhilko.auth.domain.interactor

import android.net.Uri
import home.vzhilko.core.domain.interactor.BaseInteractor
import home.vzhilko.core.domain.network.OAUTH_CALLBACK_URL
import home.vzhilko.core.domain.network.OAUTH_CLIENT_ID
import home.vzhilko.core.domain.network.OAUTH_CLIENT_SECRET
import home.vzhilko.core.domain.network.OAUTH_CODE_KEY
import home.vzhilko.auth.domain.entity.AuthParamsEntity
import home.vzhilko.auth.domain.repository.IAuthRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class AuthorizationInteractor constructor(private val authRepository: IAuthRepository) :
    BaseInteractor {

    fun authorize(redirectUri: Uri?): Single<Unit> {
        return redirectUri?.let { url ->
            if (url.toString().startsWith(OAUTH_CALLBACK_URL)) {
                val oauthCode: String? = url.getQueryParameter(OAUTH_CODE_KEY)
                oauthCode?.let {
                    authRepository.saveAuthorizationCode(it)
                    authRepository.getAccessToken(
                        AuthParamsEntity(
                            OAUTH_CLIENT_ID,
                            OAUTH_CLIENT_SECRET,
                            it,
                            OAUTH_CALLBACK_URL
                        )
                    )
                        .doOnSuccess { response -> authRepository.saveAccessToken(response?.accessToken) }
                        .map { Unit }
                        .subscribeOn(Schedulers.io())
                } ?: Single.error<Unit>(Exception())
            } else {
                Single.error<Unit>(Exception())
            }
        } ?: Single.error<Unit>(Exception())
    }

}