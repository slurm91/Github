package home.vzhilko.github.base.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import home.vzhilko.github.base.di.annotation.ActivityScope
import home.vzhilko.github.base.view.activity.MainActivity

@Module
abstract class ActivityInjectorFactoryModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainActivitySubcomponentBuildersModule::class,
            UserModule::class
        ]
    )
    abstract fun contributeMainActivityInjector(): MainActivity

}