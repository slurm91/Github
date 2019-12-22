package home.vzhilko.github.feature.main.viewmodel

import androidx.lifecycle.MutableLiveData
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.domain.feature.main.interactor.IMainInteractor
import home.vzhilko.github.App
import home.vzhilko.github.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(app: App, private val mainInteractor: IMainInteractor) :
    BaseViewModel(app, mainInteractor), IMainInteractor.MainInteractorCallback {

    init {
        mainInteractor.callback = this
    }

    fun getRepositoriesList() {
        mainInteractor.getRepositoriesList()
    }

    val repositoriesListLiveData: MutableLiveData<List<RepositoryEntity>> = MutableLiveData()

    override fun showRepositoriesList(list: List<RepositoryEntity>) {
        repositoriesListLiveData.value = list
    }

}