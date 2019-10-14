package home.vzhilko.github

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import home.vzhilko.github.base.di.component.AppComponent
import home.vzhilko.github.base.di.component.DaggerAppComponent

class App : DaggerApplication() {

    //Test
    private lateinit var appComponent: AppComponent

    companion object {
        lateinit var app: App

        fun getInstance(): AppComponent {
            return app.appComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().appModule(this).build()
        return appComponent
    }

}