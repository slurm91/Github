package home.vzhilko.domain.feature.main.interactor

import home.vzhilko.domain.base.interactor.BaseInteractor
import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.domain.feature.main.repository.IMainRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainInteractor @Inject constructor(private val mainRepository: IMainRepository) :
    BaseInteractor {

    fun getRepositoriesList(): Single<List<RepositoryEntity>> {
        return mainRepository.getRepositoriesList().subscribeOn(Schedulers.io())
    }

}