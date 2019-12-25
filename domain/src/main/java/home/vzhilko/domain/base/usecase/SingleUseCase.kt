package home.vzhilko.domain.base.usecase

import io.reactivex.Single

interface SingleUseCase<T> : UseCase<Single<T>> {

    fun buildSingleUseCase(): Single<T>

    override fun execute(): Single<T> {
        return buildSingleUseCase()
    }

}