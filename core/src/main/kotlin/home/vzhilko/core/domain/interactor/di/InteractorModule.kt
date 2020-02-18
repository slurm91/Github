package home.vzhilko.core.domain.interactor.di

import home.vzhilko.core.domain.interactor.AppInteractor
import org.koin.core.module.Module
import org.koin.dsl.module

val interactorModule = module {
    factory { AppInteractor(get()) }
}

fun getInteractorModules(): List<Module> = listOf(interactorModule)