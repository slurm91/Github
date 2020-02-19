package home.vzhilko.core.data.storage.settings

import android.content.Context
import android.content.SharedPreferences
import home.vzhilko.core.BuildConfig

class Settings(context: Context): ISettings {

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