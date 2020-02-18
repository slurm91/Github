package home.vzhilko.core.presentation.viewmodel

import android.app.Application
import android.webkit.CookieManager
import home.vzhilko.core.domain.interactor.AppInteractor

class AppViewModel constructor(
    application: Application,
    private val appInteractor: AppInteractor
) : BaseViewModel(application) {

    fun signOut() {
        CookieManager.getInstance().removeAllCookies(null)
        appInteractor.singOut()
    }

}