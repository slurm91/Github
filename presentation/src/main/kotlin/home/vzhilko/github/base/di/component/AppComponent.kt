package home.vzhilko.github.base.di.component

import home.vzhilko.data.base.repository.di.getRepositoryModules
import home.vzhilko.data.base.storage.network.di.getHttpClientModules
import home.vzhilko.data.base.storage.network.di.getServiceApiModules
import home.vzhilko.data.base.storage.preferences.di.getKeyValueDatabaseModules
import home.vzhilko.domain.base.interactor.di.getInteractorModules
import home.vzhilko.github.App
import home.vzhilko.github.base.di.module.getViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

fun init(app: App) {
    startKoin {
        androidLogger()
        androidContext(app)
        modules(getKeyValueDatabaseModules())
        modules(getHttpClientModules())
        modules(getServiceApiModules())
        modules(getRepositoryModules())
        modules(getInteractorModules())
        modules(getViewModelModules())
    }
}
