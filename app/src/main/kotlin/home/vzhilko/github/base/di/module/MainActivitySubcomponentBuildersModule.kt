package home.vzhilko.github.base.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import home.vzhilko.github.base.di.annotation.FragmentScope
import home.vzhilko.github.feature.start.view.fragment.StartFragment
import home.vzhilko.github.feature.test.view.fragment.TestFragment
import home.vzhilko.github.feature.test.view.fragment.TestListFragment

@Module
abstract class MainActivitySubcomponentBuildersModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun contributeStartFragmentInjector(): StartFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun contributeTestFragmentInjector(): TestFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeTestListFragmentInjector(): TestListFragment

}