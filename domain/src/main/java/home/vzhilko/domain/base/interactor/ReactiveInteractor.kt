package home.vzhilko.domain.base.interactor

import io.reactivex.disposables.CompositeDisposable

interface ReactiveInteractor : BaseInteractor {

    val disposables: CompositeDisposable
        get() = CompositeDisposable()

    override fun release() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

}