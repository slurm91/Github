package home.vzhilko.core.data.storage.settings

interface ISettings {

    fun putString(key: String?, value: String?)

    fun getString(key: String?): String?

}