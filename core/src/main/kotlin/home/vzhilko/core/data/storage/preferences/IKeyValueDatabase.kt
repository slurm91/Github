package home.vzhilko.core.data.storage.preferences

interface IKeyValueDatabase {

    fun putString(key: String?, value: String?)

    fun getString(key: String?): String?

}