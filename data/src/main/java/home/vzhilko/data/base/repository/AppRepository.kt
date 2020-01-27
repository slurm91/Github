package home.vzhilko.data.base.repository

import home.vzhilko.data.base.storage.preferences.IKeyValueDatabase
import home.vzhilko.domain.base.preferences.constant.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.domain.base.preferences.constant.KEY_VALUE_AUTHORIZATION_CODE_KEY
import home.vzhilko.domain.base.repository.IAppRepository

class AppRepository constructor (private val keyValueDatabase: IKeyValueDatabase) : IAppRepository {

    override fun signOut() {
        keyValueDatabase.putString(KEY_VALUE_AUTHORIZATION_CODE_KEY, null)
        keyValueDatabase.putString(KEY_VALUE_ACCESS_TOKEN_KEY, null)
    }

}