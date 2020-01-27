package home.vzhilko.data.base.storage.network.di

import home.vzhilko.data.feature.auth.api.AuthApiService
import home.vzhilko.data.feature.main.api.MainApiService
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceApiModule = module {
    factory {
        getApiService<AuthApiService>(
            get(named(OAUTH_API_RETROFIT_TAG))
        )
    }
    factory {
        getApiService<MainApiService>(
            get()
        )
    }
}

private inline fun <reified T> getApiService(retrofit: Retrofit): T = retrofit.create(T::class.java)

fun getServiceApiModules(): List<Module> = listOf(serviceApiModule)