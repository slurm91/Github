package home.vzhilko.main

import home.vzhilko.core.data.util.getApiService
import home.vzhilko.main.data.api.MainApiService
import home.vzhilko.main.data.repository.MainRepository
import home.vzhilko.main.domain.interactor.MainInteractor
import home.vzhilko.main.domain.repository.IMainRepository
import home.vzhilko.main.presentation.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val authorizationModelModule = module {
    factory {
        getApiService<MainApiService>(
            get()
        )
    }
    factory<IMainRepository> { MainRepository(get()) }
    factory { MainInteractor(get()) }
    viewModel { MainViewModel(androidApplication(), get()) }
}

fun getMainModules(): List<Module> = listOf(authorizationModelModule)