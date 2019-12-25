package home.vzhilko.data.feature.auth.repository

import home.vzhilko.data.base.preferences.IKeyValueDatabase
import home.vzhilko.data.feature.auth.api.AuthApiService
import home.vzhilko.data.feature.auth.mapper.mapFromAuthParamsEntity
import home.vzhilko.data.feature.auth.mapper.mapToAuthEntity
import home.vzhilko.domain.base.preferences.constant.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.domain.base.preferences.constant.KEY_VALUE_AUTHORIZATION_CODE_KEY
import home.vzhilko.domain.feature.auth.entity.AuthEntity
import home.vzhilko.domain.feature.auth.entity.AuthParamsEntity
import home.vzhilko.domain.feature.auth.repository.IAuthRepository
import io.reactivex.Single
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: AuthApiService,
    private val keyValueDatabase: IKeyValueDatabase
) : IAuthRepository {

    override fun getAccessToken(body: AuthParamsEntity): Single<AuthEntity> {
        return apiService.getAccessToken(mapFromAuthParamsEntity(body)).map { mapToAuthEntity(it) }
    }

    override fun saveAccessToken(value: String?) {
        keyValueDatabase.putString(KEY_VALUE_ACCESS_TOKEN_KEY, value)
    }

    override fun saveAuthorizationCode(value: String?) {
        keyValueDatabase.putString(KEY_VALUE_AUTHORIZATION_CODE_KEY, value)
    }

}