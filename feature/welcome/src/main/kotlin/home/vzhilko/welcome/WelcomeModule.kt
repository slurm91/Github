package home.vzhilko.welcome

import home.vzhilko.welcome.presentation.viewmodel.WelcomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val welcomeModule = module {
    viewModel { WelcomeViewModel(androidApplication()) }
}

fun getWelcomeModules(): List<Module> = listOf(welcomeModule)