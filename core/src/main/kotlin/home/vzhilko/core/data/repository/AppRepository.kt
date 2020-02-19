package home.vzhilko.core.data.repository

import home.vzhilko.core.domain.settings.KEY_VALUE_ACCESS_TOKEN_KEY
import home.vzhilko.core.domain.settings.KEY_VALUE_AUTHORIZATION_CODE_KEY
import home.vzhilko.core.domain.repository.IAppRepository
import home.vzhilko.core.data.storage.settings.ISettings

class AppRepository constructor (private val settings: ISettings) : IAppRepository {

    override fun signOut() {
        settings.putString(KEY_VALUE_AUTHORIZATION_CODE_KEY, null)
        settings.putString(KEY_VALUE_ACCESS_TOKEN_KEY, null)
    }

}