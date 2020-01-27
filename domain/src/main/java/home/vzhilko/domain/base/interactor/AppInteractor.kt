package home.vzhilko.domain.base.interactor

import home.vzhilko.domain.base.repository.IAppRepository

class AppInteractor constructor(private val appRepository: IAppRepository) : BaseInteractor {

    fun singOut() {
        appRepository.signOut()
    }

}