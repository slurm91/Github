package home.vzhilko.data.base.network.interceptor

import home.vzhilko.data.base.preferences.IKeyValueDatabase
import home.vzhilko.domain.base.preferences.constant.KEY_VALUE_ACCESS_TOKEN_KEY
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