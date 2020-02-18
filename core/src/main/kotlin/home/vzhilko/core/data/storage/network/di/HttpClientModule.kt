package home.vzhilko.core.data.storage.network.di

import com.facebook.stetho.okhttp3.StethoInterceptor
import home.vzhilko.core.data.storage.network.*
import home.vzhilko.core.data.storage.network.interceptor.HttpClientInterceptor
import home.vzhilko.core.data.storage.network.interceptor.OAuthHttpClientInterceptor
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val OAUTH_API_URL_TAG: String = "OAUTH_API_URL_TAG"
const val OAUTH_API_OK_HTTP_TAG: String = "OAUTH_API_OK_HTTP_TAG"
const val OAUTH_API_RETROFIT_TAG: String = "OAUTH_API_RETROFIT_TAG"

val urlModule = module {
    single(named(OAUTH_API_URL_TAG)) { provideOAuthApiUrl() }
    single { provideApiUrl() }
}

val gsonModule = module {
    factory { provideGsonConverterFactory() }
}

val httpClientInterceptorModule = module {
    factory { provideLogInterceptor() }
    factory { StethoInterceptor() }
    factory { OAuthHttpClientInterceptor() }
    factory { HttpClientInterceptor(get()) }
}

val httpClientModule = module {
    factory { provideRetrofitBuilder(get()) }
    single(named(OAUTH_API_OK_HTTP_TAG)) {
        provideOAuthOkHttpBuilder(
            get(),
            get(),
            get()
        )
    }
    single(named(OAUTH_API_RETROFIT_TAG)) {
        provideOAuthRetrofit(
            get(named(OAUTH_API_OK_HTTP_TAG)),
            get(),
            get(named(OAUTH_API_URL_TAG))
        )
    }
    single {
        provideOkHttpBuilder(
            get(),
            get(),
            get()
        )
    }
    single {
        provideRetrofit(
            get(),
            get(),
            get()
        )
    }
}

fun getHttpClientModules(): List<Module> = listOf(
    urlModule,
    gsonModule,
    httpClientInterceptorModule,
    httpClientModule
)