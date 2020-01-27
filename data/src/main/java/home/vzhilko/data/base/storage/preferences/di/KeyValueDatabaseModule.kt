package home.vzhilko.data.base.storage.preferences.di

import home.vzhilko.data.base.storage.preferences.IKeyValueDatabase
import home.vzhilko.data.base.storage.preferences.KeyValueDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val keyValueDatabaseModule = module {
    single<IKeyValueDatabase> { KeyValueDatabase(androidContext()) }
}

fun getKeyValueDatabaseModules(): List<Module> = listOf(keyValueDatabaseModule)