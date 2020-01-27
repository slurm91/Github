package home.vzhilko.data.base.storage.preferences

interface IKeyValueDatabase {

    fun putString(key: String?, value: String?)

    fun getString(key: String?): String?

}