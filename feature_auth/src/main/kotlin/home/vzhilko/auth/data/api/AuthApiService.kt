package home.vzhilko.auth.data.api

import home.vzhilko.auth.data.dto.AuthRequestDto
import home.vzhilko.auth.data.dto.AuthResponseDto
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {

    @POST("login/oauth/access_token")
    fun getAccessToken(@Body requestDto: AuthRequestDto): Single<AuthResponseDto>

}