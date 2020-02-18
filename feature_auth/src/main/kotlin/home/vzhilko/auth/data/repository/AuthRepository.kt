package home.vzhilko.auth.data.repository

import home.vzhilko.auth.data.api.AuthApiService
import home.vzhilko.auth.data.mapper.mapFromAuthParamsEntity
import home.vzhilko.auth.data.mapper.mapToAuthEntity
import home.vzhilko.auth.domain.entity.AuthEntity
import home.vzhilko.auth.domain.entity.AuthParamsEntity
import home.vzhilko.auth.domain.repository.IAuthRepository
import home.vzhilko.core.data.storage.preferences.IKeyValueDatabase
import home.vzhilko.core.domain.constant.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.core.domain.constant.KEY_VALUE_AUTHORIZATION_CODE_KEY
import io.reactivex.Single

class AuthRepository constructor(
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