package home.vzhilko.start

import home.vzhilko.start.presentation.viewmodel.StartViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val startModule = module {
    viewModel { StartViewModel(androidApplication()) }
}

fun getStartModules(): List<Module> = listOf(startModule)