package home.vzhilko.core.data.storage.network.interceptor

import home.vzhilko.core.domain.settings.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.core.data.storage.settings.ISettings
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HttpClientInterceptor(private val settings: ISettings) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader(
                "Authorization",
                "token ${settings.getString(KEY_VALUE_ACCESS_TOKEN_KEY)}"
            )
            .build()

        return chain.proceed(request)
    }

}