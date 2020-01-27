package home.vzhilko.data.base.repository.di

import home.vzhilko.data.base.repository.AppRepository
import home.vzhilko.data.feature.auth.repository.AuthRepository
import home.vzhilko.data.feature.main.repository.MainRepository
import home.vzhilko.domain.base.repository.IAppRepository
import home.vzhilko.domain.feature.auth.repository.IAuthRepository
import home.vzhilko.domain.feature.main.repository.IMainRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule = module {
    factory<IAppRepository> { AppRepository(get()) }
    factory<IAuthRepository> { AuthRepository(get(), get()) }
    factory<IMainRepository> { MainRepository(get()) }
}

fun getRepositoryModules(): List<Module> = listOf(repositoryModule)