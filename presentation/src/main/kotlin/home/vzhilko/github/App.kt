package home.vzhilko.github

import android.app.Application
import com.facebook.stetho.Stetho
import home.vzhilko.github.base.di.component.init

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        init(this)
        Stetho.initializeWithDefaults(this)
    }

}