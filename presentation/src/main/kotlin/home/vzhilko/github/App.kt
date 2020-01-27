package home.vzhilko.github

import android.app.Application
import com.facebook.stetho.Stetho
import home.vzhilko.github.base.di.component.init

class App : Application() {

    companion object {
        private lateinit var app: App

        fun getInstance(): App {
            return app
        }
    }

    override fun onCreate() {
        super.onCreate()
        init(this)
        app = this
        Stetho.initializeWithDefaults(this)
    }

}