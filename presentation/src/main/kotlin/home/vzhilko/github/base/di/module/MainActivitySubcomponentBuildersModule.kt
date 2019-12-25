package home.vzhilko.github.base.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import home.vzhilko.domain.base.scope.FragmentScope
import home.vzhilko.github.feature.auth.view.fragment.AuthorizationFragment
import home.vzhilko.github.feature.main.view.fragment.MainFragment
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

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeAuthFragmentFragmentInjector(): AuthorizationFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun contributeMainFragmentFragmentInjector(): MainFragment

}