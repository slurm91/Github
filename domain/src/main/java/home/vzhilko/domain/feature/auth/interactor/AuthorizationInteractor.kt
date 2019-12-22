package home.vzhilko.domain.feature.auth.interactor

import android.net.Uri
import home.vzhilko.domain.base.network.OAUTH_CALLBACK_URL
import home.vzhilko.domain.base.network.OAUTH_CLIENT_ID
import home.vzhilko.domain.base.network.OAUTH_CLIENT_SECRET
import home.vzhilko.domain.base.network.OAUTH_CODE_KEY
import home.vzhilko.domain.feature.auth.entity.AuthEntity
import home.vzhilko.domain.feature.auth.entity.AuthParamsEntity
import home.vzhilko.domain.feature.auth.repository.IAuthRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AuthorizationInteractor @Inject constructor(private val authRepository: IAuthRepository) :
    IAuthorizationInteractor {
    override var callback: IAuthorizationInteractor.AuthorizationInteractorCallback? = null

    override fun authorize(redirectUri: Uri?) {
        redirectUri?.apply {
            if (toString().startsWith(OAUTH_CALLBACK_URL)) {
                val oauthCode: String? = getQueryParameter(OAUTH_CODE_KEY)
                oauthCode?.let {
                    authRepository.saveAuthorizationCode(it)
                    disposables.add(
                        authRepository.getAccessToken(
                            AuthParamsEntity(
                                OAUTH_CLIENT_ID,
                                OAUTH_CLIENT_SECRET,
                                it,
                                OAUTH_CALLBACK_URL
                            )
                        ).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeWith(object : DisposableSingleObserver<AuthEntity>() {
                                override fun onSuccess(response: AuthEntity) {
                                    authRepository.saveAccessToken(response.accessToken)
                                    callback?.handleSuccessfulAuthorization()
                                }

                                override fun onError(e: Throwable) {
                                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                }
                            })
                    )
                }
            }
        }
    }

}