package home.vzhilko.data.base.preferences

interface IKeyValueDatabase {

    fun putString(key: String?, value: String?)

    fun getString(key: String?): String?

}