package home.vzhilko.core.data.storage.network.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class OAuthHttpClientInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .build()

        return chain.proceed(request)
    }
}