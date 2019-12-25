package home.vzhilko.github.base.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import home.vzhilko.github.base.viewmodel.ViewModelFactory
import home.vzhilko.github.base.di.annotation.ViewModelKey
import home.vzhilko.github.base.viewmodel.AppViewModel
import home.vzhilko.github.feature.auth.viewmodel.AuthorizationViewModel
import home.vzhilko.github.feature.main.viewmodel.MainViewModel
import home.vzhilko.github.feature.start.viewmodel.StartViewModel
import home.vzhilko.github.feature.test.viewmodel.TestListViewModel
import home.vzhilko.github.feature.test.viewmodel.TestViewModel

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    abstract fun bindStartViewModel(viewModel: StartViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestViewModel::class)
    abstract fun bindTestViewModel(viewModel: TestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TestListViewModel::class)
    abstract fun bindTestListViewModel(viewModel: TestListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AppViewModel::class)
    abstract fun bindAppViewModel(viewModel: AppViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthorizationViewModel::class)
    abstract fun bindAuthorizationViewModel(viewModel: AuthorizationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}