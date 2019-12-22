package home.vzhilko.data.base.network.di.module

import dagger.Module
import dagger.Provides
import home.vzhilko.data.base.network.di.annotation.ApiUrl
import home.vzhilko.data.base.network.di.annotation.OAuthApiUrl
import home.vzhilko.domain.base.network.GITHUB_API_URL
import home.vzhilko.domain.base.network.GITHUB_URL
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

@Module
class HttpUrlModule {

    @OAuthApiUrl
    @Provides
    fun provideGithubUrl(): HttpUrl {
        return GITHUB_URL.toHttpUrl()
    }

    @ApiUrl
    @Provides
    fun provideGithubApiUrl(): HttpUrl {
        return GITHUB_API_URL.toHttpUrl()
    }

}