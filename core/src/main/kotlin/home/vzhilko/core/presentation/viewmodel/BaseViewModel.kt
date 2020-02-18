package home.vzhilko.core.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()

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