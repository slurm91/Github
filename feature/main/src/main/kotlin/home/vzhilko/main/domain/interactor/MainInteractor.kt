package home.vzhilko.main.domain.interactor

import home.vzhilko.core.domain.interactor.BaseInteractor
import home.vzhilko.main.domain.entity.RepositoryEntity
import home.vzhilko.main.domain.repository.IMainRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class MainInteractor constructor(private val mainRepository: IMainRepository) : BaseInteractor {

    fun getRepositoriesList(): Single<List<RepositoryEntity>> {
        return mainRepository.getRepositoriesList().subscribeOn(Schedulers.io())
    }

}