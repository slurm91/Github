package home.vzhilko.github.base.viewmodel

import androidx.lifecycle.AndroidViewModel
import home.vzhilko.github.App
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(app: App) : AndroidViewModel(app) {

    private val subscribers: CompositeDisposable = CompositeDisposable()

    protected fun addSubscriber(subscriber: Disposable) {
        subscribers.add(subscriber)
    }

    private fun removeAllSubscribers(){
        if (!subscribers.isDisposed) {
            subscribers.dispose()
        }
    }

    override fun onCleared() {
        super.onCleared()
        removeAllSubscribers()
    }

}