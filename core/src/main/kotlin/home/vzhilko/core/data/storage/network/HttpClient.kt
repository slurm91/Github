package home.vzhilko.core.data.storage.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import home.vzhilko.core.data.storage.network.interceptor.HttpClientInterceptor
import home.vzhilko.core.data.storage.network.interceptor.OAuthHttpClientInterceptor
import home.vzhilko.core.domain.network.GITHUB_API_URL
import home.vzhilko.core.domain.network.GITHUB_URL
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun provideGsonConverterFactory(): GsonConverterFactory {
    val gson: Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    return GsonConverterFactory.create(gson)
}

fun provideLogInterceptor(): HttpLoggingInterceptor {
    val logInterceptor = HttpLoggingInterceptor()
    logInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return logInterceptor
}

fun provideRetrofitBuilder(gsonConverterFactory: GsonConverterFactory): Retrofit.Builder {
    return Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
}

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

fun provideRetrofit(
    okHttpClientBuilder: OkHttpClient.Builder,
    retrofitBuilder: Retrofit.Builder,
    url: HttpUrl
): Retrofit {
    return retrofitBuilder
        .client(okHttpClientBuilder.build())
        .baseUrl(url)
        .build()
}

fun provideApiUrl(): HttpUrl {
    return GITHUB_API_URL.toHttpUrl()
}

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

fun provideOAuthRetrofit(
    okHttpClientBuilder: OkHttpClient.Builder,
    retrofitBuilder: Retrofit.Builder,
    url: HttpUrl
): Retrofit {
    return retrofitBuilder
        .client(okHttpClientBuilder.build())
        .baseUrl(url)
        .build()
}

fun provideOAuthApiUrl(): HttpUrl {
    return GITHUB_URL.toHttpUrl()
}