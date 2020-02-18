package home.vzhilko.core.data.util

import retrofit2.Retrofit

inline fun <reified T> getApiService(retrofit: Retrofit): T = retrofit.create(T::class.java)