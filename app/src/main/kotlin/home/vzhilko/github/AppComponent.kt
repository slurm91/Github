package home.vzhilko.github

import home.vzhilko.auth.getAuthorizationModules
import home.vzhilko.core.data.repository.di.getRepositoryModules
import home.vzhilko.core.data.storage.network.di.getHttpClientModules
import home.vzhilko.core.data.storage.settings.di.getSettingsModules
import home.vzhilko.core.domain.interactor.di.getInteractorModules
import home.vzhilko.core.presentation.viewmodel.di.getViewModelModules
import home.vzhilko.main.getMainModules
import home.vzhilko.welcome.getWelcomeModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

fun init(app: App) {
    startKoin {
        androidLogger()
        androidContext(app)
        //Core
        modules(getHttpClientModules())
        modules(getSettingsModules())
        modules(getRepositoryModules())
        modules(getInteractorModules())
        modules(getViewModelModules())
        //Features
        modules(getWelcomeModules())
        modules(getAuthorizationModules())
        modules(getMainModules())
    }
}
