package home.vzhilko.auth

import home.vzhilko.auth.data.api.AuthApiService
import home.vzhilko.auth.data.repository.AuthRepository
import home.vzhilko.auth.domain.interactor.AuthorizationInteractor
import home.vzhilko.auth.domain.repository.IAuthRepository
import home.vzhilko.auth.presentation.viewmodel.AuthorizationViewModel
import home.vzhilko.core.data.storage.network.di.OAUTH_API_RETROFIT_TAG
import home.vzhilko.core.data.util.getApiService
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named

val authorizationModelModule = module {
    factory {
        getApiService<AuthApiService>(
            get(named(OAUTH_API_RETROFIT_TAG))
        )
    }
    factory<IAuthRepository> { AuthRepository(get(), get()) }
    factory { AuthorizationInteractor(get()) }
    viewModel { AuthorizationViewModel(androidApplication(), get()) }
}

fun getAuthorizationModules(): List<Module> = listOf(authorizationModelModule)