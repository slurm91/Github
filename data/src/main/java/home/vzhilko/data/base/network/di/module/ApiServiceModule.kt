package home.vzhilko.data.base.network.di.module

import dagger.Module
import dagger.Provides
import home.vzhilko.data.base.network.di.annotation.Api
import home.vzhilko.data.base.network.di.annotation.OAuthApi
import home.vzhilko.data.feature.auth.api.AuthApiService
import home.vzhilko.data.feature.main.api.MainApiService
import retrofit2.Retrofit

@Module
class ApiServiceModule {

    @Provides
    fun provideAuthApiService(@OAuthApi retrofit: Retrofit): AuthApiService {
        return retrofit.create(AuthApiService::class.java)
    }

    @Provides
    fun provideMaiApiService(@Api retrofit: Retrofit): MainApiService {
        return retrofit.create(MainApiService::class.java)
    }

}