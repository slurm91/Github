package home.vzhilko.auth.domain.repository

import home.vzhilko.auth.domain.entity.AuthEntity
import home.vzhilko.auth.domain.entity.AuthParamsEntity
import io.reactivex.Single

interface IAuthRepository {

    fun getAccessToken(body: AuthParamsEntity): Single<AuthEntity>

    fun saveAccessToken(value: String?)

    fun saveAuthorizationCode(value: String?)

}