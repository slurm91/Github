package home.vzhilko.domain.base.interactor

import home.vzhilko.domain.base.repository.IAppRepository
import javax.inject.Inject

class AppInteractor @Inject constructor(private val appRepository: IAppRepository) : IAppInteractor {

    override fun singOut() {
        appRepository.signOut()
    }

}