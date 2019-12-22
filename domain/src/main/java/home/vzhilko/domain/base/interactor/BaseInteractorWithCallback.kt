package home.vzhilko.domain.base.interactor

interface BaseInteractorWithCallback<C> : BaseInteractor {

    var callback: C?

    override fun release() {
        callback = null
    }

}