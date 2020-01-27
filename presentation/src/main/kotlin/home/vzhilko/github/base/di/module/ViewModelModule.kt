package home.vzhilko.github.base.di.module

import home.vzhilko.github.App
import home.vzhilko.github.base.viewmodel.AppViewModel
import home.vzhilko.github.feature.auth.viewmodel.AuthorizationViewModel
import home.vzhilko.github.feature.main.viewmodel.MainViewModel
import home.vzhilko.github.feature.start.viewmodel.StartViewModel
import home.vzhilko.github.feature.test.viewmodel.TestListViewModel
import home.vzhilko.github.feature.test.viewmodel.TestViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { AppViewModel(androidApplication() as App, get()) }
    viewModel { StartViewModel(androidApplication() as App) }
    viewModel { AuthorizationViewModel(androidApplication() as App, get()) }
    viewModel { MainViewModel(androidApplication() as App, get()) }

    viewModel { TestViewModel(androidApplication() as App) }
    viewModel { TestListViewModel(androidApplication() as App) }
}

fun getViewModelModules(): List<Module> = listOf(viewModelModule)