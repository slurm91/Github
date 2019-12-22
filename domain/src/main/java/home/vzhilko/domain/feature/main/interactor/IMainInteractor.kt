package home.vzhilko.domain.feature.main.interactor

import home.vzhilko.domain.base.interactor.ReactiveInteractorWithCallback
import home.vzhilko.domain.feature.main.entity.RepositoryEntity

interface IMainInteractor : ReactiveInteractorWithCallback<IMainInteractor.MainInteractorCallback> {

    fun getRepositoriesList()

    interface MainInteractorCallback {

        fun showRepositoriesList(list: List<RepositoryEntity>)

    }

}