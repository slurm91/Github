package home.vzhilko.domain.base.interactor.di

import org.koin.core.module.Module
import org.koin.dsl.module

val interactorModule = module {

}

fun getInteractorModules(): List<Module> = listOf(interactorModule)