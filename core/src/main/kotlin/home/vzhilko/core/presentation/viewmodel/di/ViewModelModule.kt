package home.vzhilko.core.presentation.viewmodel.di

import home.vzhilko.core.presentation.viewmodel.AppViewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel

val viewModelModule = module {
    viewModel { AppViewModel(androidApplication(), get()) }
}

fun getViewModelModules(): List<Module> = listOf(viewModelModule)