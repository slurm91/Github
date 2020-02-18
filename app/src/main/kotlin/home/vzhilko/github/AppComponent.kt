package home.vzhilko.github

import home.vzhilko.auth.getAuthorizationModules
import home.vzhilko.core.data.repository.di.getRepositoryModules
import home.vzhilko.core.data.storage.network.di.getHttpClientModules
import home.vzhilko.core.data.storage.preferences.di.getKeyValueDatabaseModules
import home.vzhilko.core.domain.interactor.di.getInteractorModules
import home.vzhilko.core.presentation.viewmodel.di.getViewModelModules
import home.vzhilko.main.getMainModules
import home.vzhilko.start.getStartModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

fun init(app: App) {
    startKoin {
        androidLogger()
        androidContext(app)
        //Core
        modules(getHttpClientModules())
        modules(getKeyValueDatabaseModules())
        modules(getRepositoryModules())
        modules(getInteractorModules())
        modules(getViewModelModules())
        //Features
        modules(getStartModules())
        modules(getAuthorizationModules())
        modules(getMainModules())
    }
}
