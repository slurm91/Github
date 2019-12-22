package home.vzhilko.github

import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import home.vzhilko.github.base.di.component.AppComponent
import home.vzhilko.github.base.di.component.DaggerAppComponent

class App : DaggerApplication() {

    private lateinit var appComponent: AppComponent

    companion object {
        private lateinit var app: App

        fun getInstance(): App {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        appComponent.inject(app)
        Stetho.initializeWithDefaults(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .context(this.applicationContext)
            .build()
        return appComponent
    }

}