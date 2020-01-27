package home.vzhilko.domain.base.interactor.di

import home.vzhilko.domain.base.interactor.AppInteractor
import home.vzhilko.domain.feature.auth.interactor.AuthorizationInteractor
import home.vzhilko.domain.feature.main.interactor.MainInteractor
import org.koin.core.module.Module
import org.koin.dsl.module

val interactorModule = module {
    factory { AppInteractor(get()) }
    factory { AuthorizationInteractor(get()) }
    factory { MainInteractor(get()) }
}

fun getInteractorModules(): List<Module> = listOf(interactorModule)