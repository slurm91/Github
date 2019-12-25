package home.vzhilko.data.base.network.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import dagger.Module
import dagger.Provides
import home.vzhilko.data.base.network.di.annotation.Api
import home.vzhilko.data.base.network.di.annotation.ApiUrl
import home.vzhilko.data.base.network.di.annotation.OAuthApi
import home.vzhilko.data.base.network.di.annotation.OAuthApiUrl
import home.vzhilko.data.base.network.interceptor.HttpClientInterceptor
import home.vzhilko.data.base.network.interceptor.OAuthHttpClientInterceptor
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class HttpClientModule {
    @OAuthApi
    @Provides
    fun provideOAuthOkHttpBuilder(
        logInterceptor: HttpLoggingInterceptor,
        stethoInterceptor: StethoInterceptor,
        OAuthHttpClientInterceptor: OAuthHttpClientInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .addInterceptor(OAuthHttpClientInterceptor)
            .addNetworkInterceptor(stethoInterceptor)
    }

    @Provides
    fun provideRetrofitBuilder(gsonConverterFactory: GsonConverterFactory): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @OAuthApi
    @Provides
    fun provideOAuthRetrofit(
        @OAuthApi okHttpClientBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder,
        @OAuthApiUrl url: HttpUrl
    ): Retrofit {
        return retrofitBuilder
            .client(okHttpClientBuilder.build())
            .baseUrl(url)
            .build()
    }

    @Api
    @Provides
    fun provideOkHttpBuilder(
        logInterceptor: HttpLoggingInterceptor,
        stethoInterceptor: StethoInterceptor,
        httpClientInterceptor: HttpClientInterceptor
    ): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .addInterceptor(httpClientInterceptor)
            .addNetworkInterceptor(stethoInterceptor)
    }

    @Api
    @Provides
    fun provideRetrofit(
        @Api okHttpClientBuilder: OkHttpClient.Builder,
        retrofitBuilder: Retrofit.Builder,
        @ApiUrl url: HttpUrl
    ): Retrofit {
        return retrofitBuilder
            .client(okHttpClientBuilder.build())
            .baseUrl(url)
            .build()
    }

}