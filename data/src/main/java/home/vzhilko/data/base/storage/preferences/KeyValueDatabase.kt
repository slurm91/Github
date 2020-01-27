package home.vzhilko.data.base.storage.preferences

import android.content.Context
import android.content.SharedPreferences
import home.vzhilko.data.BuildConfig

class KeyValueDatabase(context: Context): IKeyValueDatabase {

    private val preferencesFileName: String =
        "${BuildConfig.LIBRARY_PACKAGE_NAME}.PREFERENCE_FILE_KEY"
    private var sharedPreferences: SharedPreferences

    init {
        sharedPreferences = context.getSharedPreferences(preferencesFileName, Context.MODE_PRIVATE)
    }

    override fun putString(key: String?, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getString(key: String?): String? {
        return sharedPreferences.getString(key, null)
    }

}