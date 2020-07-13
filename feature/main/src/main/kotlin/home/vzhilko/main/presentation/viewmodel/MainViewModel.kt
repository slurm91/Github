package home.vzhilko.main.presentation.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import home.vzhilko.core.base.extension.logDebug
import home.vzhilko.core.domain.entity.MessageEntity
import home.vzhilko.core.presentation.navigation.NavigationEvent
import home.vzhilko.core.presentation.view.dialog.BaseDialogModel
import home.vzhilko.core.presentation.viewmodel.BaseViewModel
import home.vzhilko.main.R
import home.vzhilko.main.domain.entity.RepositoryEntity
import home.vzhilko.main.domain.interactor.MainInteractor

class MainViewModel constructor(
    application: Application,
    private val mainInteractor: MainInteractor
) : BaseViewModel(application) {

    private val _repositoriesListLiveData: MutableLiveData<List<RepositoryEntity>> = MutableLiveData()
    val repositoriesListLiveData: LiveData<List<RepositoryEntity>> = _repositoriesListLiveData

    @SuppressLint("CheckResult")
    fun getRepositoriesList() {
        addSubscriber(mainInteractor.getRepositoriesList()
            .doOnSubscribe { progressLiveData.postValue(true) }
            .subscribe(
                { response ->
                    progressLiveData.postValue(false)
                    _repositoriesListLiveData.postValue(response)
                },
                { error ->
                    progressLiveData.postValue(false)
                    "No repositories, error message: ${error.message}".logDebug()
                }
            ))
    }

    fun onBackPressed() {
        val regularDialogModel = BaseDialogModel(
            MessageEntity(getApp().getString(R.string.regular_sign_out_question_caption), ""),
            getApp().getString(R.string.regular_ok_caption)
        ).apply {
            cancelButtonText = getApp().getString(R.string.regular_cancel_caption)
            isCancelButtonShown = true
            onConfirmationButtonClickAction = { dialog ->
                navigationEventLiveData.value = NavigationEvent(NavigationEvent.RETURN_BACK_EVENT_ID)
            }
        }

        updateDialogModel(regularDialogModel)
    }

}