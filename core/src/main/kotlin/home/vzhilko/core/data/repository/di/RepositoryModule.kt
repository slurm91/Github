package home.vzhilko.core.data.repository.di

import home.vzhilko.core.data.repository.AppRepository
import home.vzhilko.core.domain.repository.IAppRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule = module {
    factory<IAppRepository> { AppRepository(get()) }
}

fun getRepositoryModules(): List<Module> = listOf(repositoryModule)