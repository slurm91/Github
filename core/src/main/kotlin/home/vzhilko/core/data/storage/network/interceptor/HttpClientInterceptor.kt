package home.vzhilko.core.data.storage.network.interceptor

import home.vzhilko.core.domain.constant.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.core.data.storage.preferences.IKeyValueDatabase
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HttpClientInterceptor(private val keyValueDatabase: IKeyValueDatabase) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
            .addHeader("Accept", "application/json")
            .addHeader(
                "Authorization",
                "token ${keyValueDatabase.getString(KEY_VALUE_ACCESS_TOKEN_KEY)}"
            )
            .build()

        return chain.proceed(request)
    }

}