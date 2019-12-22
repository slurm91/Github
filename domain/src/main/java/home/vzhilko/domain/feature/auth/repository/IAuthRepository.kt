package home.vzhilko.domain.feature.auth.repository

import home.vzhilko.domain.feature.auth.entity.AuthEntity
import home.vzhilko.domain.feature.auth.entity.AuthParamsEntity
import io.reactivex.Single

interface IAuthRepository {

    fun getAccessToken(body: AuthParamsEntity): Single<AuthEntity>

    fun saveAccessToken(value: String?)

    fun saveAuthorizationCode(value: String?)

}