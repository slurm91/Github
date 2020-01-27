package home.vzhilko.github.feature.main.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import home.vzhilko.domain.extension.logDebug
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.domain.feature.main.interactor.MainInteractor
import home.vzhilko.github.App
import home.vzhilko.github.base.viewmodel.BaseViewModel

class MainViewModel constructor(app: App, private val mainInteractor: MainInteractor) :
    BaseViewModel(app) {

    private val _repositoriesListLiveData: MutableLiveData<List<RepositoryEntity>> =
        MutableLiveData()
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

}