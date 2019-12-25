package home.vzhilko.github.base.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import home.vzhilko.domain.base.scope.ActivityScope
import home.vzhilko.github.base.view.activity.AppActivity

@Module
abstract class ActivityInjectorFactoryModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivitySubcomponentBuildersModule::class,
            UserModule::class
        ]
    )
    abstract fun contributeMainActivityInjector(): AppActivity

}