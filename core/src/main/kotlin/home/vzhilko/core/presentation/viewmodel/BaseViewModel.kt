package home.vzhilko.core.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.hadilq.liveevent.LiveEvent
import home.vzhilko.core.presentation.navigation.NavigationEvent
import home.vzhilko.core.presentation.view.dialog.BaseDialogModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    //region Progress bar
    val progressLiveData: MutableLiveData<Boolean> = MutableLiveData()
    //endregion

    //region Dialog
    val dialogModelLiveData: MutableLiveData<BaseDialogModel> = MutableLiveData()
    val dialogModelSingleLiveData: LiveEvent<BaseDialogModel> = LiveEvent()

    fun updateDialogModel(model: BaseDialogModel) {
        dialogModelSingleLiveData.value = model
    }
    //endregion

    val navigationEventLiveData: LiveEvent<NavigationEvent> = LiveEvent()

    fun updateNavigationEvent(event: NavigationEvent) {
        navigationEventLiveData.value = event
    }

    private val subscribers: CompositeDisposable = CompositeDisposable()

    protected fun addSubscriber(subscriber: Disposable) {
        subscribers.add(subscriber)
    }

    private fun removeAllSubscribers() {
        if (!subscribers.isDisposed) {
            subscribers.dispose()
        }
    }

    override fun onCleared() {
        super.onCleared()
        removeAllSubscribers()
    }

    fun getApp(): Application {
        return getApplication()
    }

}