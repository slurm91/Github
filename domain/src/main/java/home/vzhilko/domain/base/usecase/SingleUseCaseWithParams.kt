package home.vzhilko.domain.base.usecase

import io.reactivex.Single

interface SingleUseCaseWithParams<P, T> :
    UseCaseWithParams<P, Single<T>> {

    fun buildSingleUseCase(params: P): Single<T>

    override fun execute(params: P): Single<T> {
        return buildSingleUseCase(params)
    }

}