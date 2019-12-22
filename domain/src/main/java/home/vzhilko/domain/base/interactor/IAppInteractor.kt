package home.vzhilko.domain.base.interactor

interface IAppInteractor : BaseInteractor {

    fun singOut()

    override fun release() {}

}