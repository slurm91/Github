package home.vzhilko.github.base.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import home.vzhilko.github.App

@Module
class AppModule(private val app: App) {

    @Provides
    fun provideApp(): App {
        return app
    }

    @Provides
    fun provideContext(): Context {
        return app.applicationContext
    }

}