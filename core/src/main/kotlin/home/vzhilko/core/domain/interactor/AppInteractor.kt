package home.vzhilko.core.domain.interactor

import home.vzhilko.core.domain.repository.IAppRepository

class AppInteractor constructor(private val appRepository: IAppRepository) : BaseInteractor {

    fun singOut() {
        appRepository.signOut()
    }

}