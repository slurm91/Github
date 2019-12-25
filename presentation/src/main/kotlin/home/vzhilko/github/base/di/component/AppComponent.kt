package home.vzhilko.github.base.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import home.vzhilko.data.base.network.di.module.*
import home.vzhilko.data.base.preferences.di.KeyValueDatabaseModule
import home.vzhilko.data.base.repository.RepositoryModule
import home.vzhilko.github.App
import home.vzhilko.domain.base.scope.ApplicationScope
import home.vzhilko.github.base.di.module.ActivityInjectorFactoryModule
import home.vzhilko.github.base.di.module.ViewModelModule

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityInjectorFactoryModule::class,

        //App modules
        ViewModelModule::class,

        //Data modules
        KeyValueDatabaseModule::class,
        GsonModule::class,
        HttpClientInterceptorModule::class,
        HttpClientModule::class,
        HttpUrlModule::class,
        ApiServiceModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}