package home.vzhilko.data.feature.auth.api

import home.vzhilko.data.feature.auth.dto.AuthRequestDto
import home.vzhilko.data.feature.auth.dto.AuthResponseDto
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("login/oauth/access_token")
    fun getAccessToken(@Body requestDto: AuthRequestDto): Single<AuthResponseDto>

}