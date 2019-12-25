package home.vzhilko.domain.base.usecase

interface UseCaseWithParams<P, T> {

    fun execute(params: P): T

}