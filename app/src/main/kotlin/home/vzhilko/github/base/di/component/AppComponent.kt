package home.vzhilko.github.base.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import home.vzhilko.github.App
import home.vzhilko.github.base.di.annotation.ApplicationScope
import home.vzhilko.github.base.di.module.ActivityInjectorFactoryModule
import home.vzhilko.github.base.di.module.ViewModelModule

@ApplicationScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityInjectorFactoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun appModule(app: App): Builder

        fun build(): AppComponent
    }

}