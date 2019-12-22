package home.vzhilko.domain.feature.main.interactor

import home.vzhilko.domain.feature.main.entity.RepositoryEntity
import home.vzhilko.domain.feature.main.repository.IMainRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainInteractor @Inject constructor(private val mainRepository: IMainRepository) :
    IMainInteractor {

    override var callback: IMainInteractor.MainInteractorCallback? = null

    override fun getRepositoriesList() {
        disposables.add(
            mainRepository.getRepositoriesList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<RepositoryEntity>?>() {
                    override fun onSuccess(response: List<RepositoryEntity>) {
                        callback?.showRepositoriesList(response)
                    }

                    override fun onError(response: Throwable) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }
                })
        )
    }

}