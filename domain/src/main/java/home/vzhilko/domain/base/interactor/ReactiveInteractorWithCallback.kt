package home.vzhilko.domain.base.interactor

import io.reactivex.disposables.CompositeDisposable

interface ReactiveInteractorWithCallback<C> : BaseInteractorWithCallback<C> {

    val disposables: CompositeDisposable
        get() = CompositeDisposable()

    override fun release() {
        super.release()
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

}