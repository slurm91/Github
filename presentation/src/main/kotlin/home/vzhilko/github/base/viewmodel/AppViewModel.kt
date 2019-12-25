package home.vzhilko.github.base.viewmodel

import android.webkit.CookieManager
import home.vzhilko.domain.base.interactor.AppInteractor
import home.vzhilko.github.App
import javax.inject.Inject

class AppViewModel @Inject constructor(app: App, private val appInteractor: AppInteractor) : BaseViewModel(app) {

    fun signOut() {
        CookieManager.getInstance().removeAllCookies(null)
        appInteractor.singOut()
    }

}