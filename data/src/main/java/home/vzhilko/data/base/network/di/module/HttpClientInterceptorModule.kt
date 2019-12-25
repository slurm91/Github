package home.vzhilko.data.base.network.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import home.vzhilko.data.base.network.interceptor.HttpClientInterceptor
import home.vzhilko.data.base.network.interceptor.OAuthHttpClientInterceptor
import home.vzhilko.data.base.preferences.IKeyValueDatabase
import okhttp3.logging.HttpLoggingInterceptor

@Module
class HttpClientInterceptorModule {

    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return logInterceptor
    }

    @Provides
    fun provideStethoInterceptor(): StethoInterceptor {
        return StethoInterceptor()
    }

    @Provides
    fun provideOAuthInterceptor(): OAuthHttpClientInterceptor {
        return OAuthHttpClientInterceptor()
    }

    @Provides
    fun provideInterceptor(keyValueDatabase: IKeyValueDatabase): HttpClientInterceptor {
        return HttpClientInterceptor(keyValueDatabase)
    }

}