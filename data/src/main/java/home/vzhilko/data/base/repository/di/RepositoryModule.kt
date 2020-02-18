package home.vzhilko.data.base.repository.di


import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule = module {

}

fun getRepositoryModules(): List<Module> = listOf(repositoryModule)