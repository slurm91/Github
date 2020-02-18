package home.vzhilko.core.data.repository

import home.vzhilko.core.domain.constant.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.core.domain.constant.KEY_VALUE_AUTHORIZATION_CODE_KEY
import home.vzhilko.core.domain.repository.IAppRepository
import home.vzhilko.core.data.storage.preferences.IKeyValueDatabase

class AppRepository constructor (private val keyValueDatabase: IKeyValueDatabase) : IAppRepository {

    override fun signOut() {
        keyValueDatabase.putString(KEY_VALUE_AUTHORIZATION_CODE_KEY, null)
        keyValueDatabase.putString(KEY_VALUE_ACCESS_TOKEN_KEY, null)
    }

}