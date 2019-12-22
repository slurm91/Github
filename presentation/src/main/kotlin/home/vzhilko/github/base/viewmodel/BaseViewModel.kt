package home.vzhilko.github.base.viewmodel

import androidx.lifecycle.AndroidViewModel
import home.vzhilko.domain.base.interactor.BaseInteractor
import home.vzhilko.github.App

abstract class BaseViewModel(app: App, private vararg val interactors: BaseInteractor?) :
    AndroidViewModel(app) {

    override fun onCleared() {
        super.onCleared()
        interactors.forEach {
            it?.release()
        }
    }

}