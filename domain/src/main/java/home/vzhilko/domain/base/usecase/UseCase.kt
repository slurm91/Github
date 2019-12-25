package home.vzhilko.domain.base.usecase

interface UseCase<T> {

    fun execute(): T

}