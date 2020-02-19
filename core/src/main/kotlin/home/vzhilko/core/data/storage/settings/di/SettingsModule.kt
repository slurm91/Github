package home.vzhilko.core.data.storage.settings.di

import home.vzhilko.core.data.storage.settings.ISettings
import home.vzhilko.core.data.storage.settings.Settings
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val settingsModule = module {
    single<ISettings> { Settings(androidContext()) }
}

fun getSettingsModules(): List<Module> = listOf(settingsModule)