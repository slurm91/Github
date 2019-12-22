package home.vzhilko.domain.base.interactor.di

import dagger.Binds
import dagger.Module
import home.vzhilko.domain.base.interactor.AppInteractor
import home.vzhilko.domain.base.interactor.IAppInteractor
import home.vzhilko.domain.feature.auth.interactor.AuthorizationInteractor
import home.vzhilko.domain.feature.auth.interactor.IAuthorizationInteractor
import home.vzhilko.domain.feature.main.interactor.IMainInteractor
import home.vzhilko.domain.feature.main.interactor.MainInteractor

@Module
abstract class InteractorModule {

    @Binds
    abstract fun provideAppInteractor(interactor: AppInteractor): IAppInteractor

    @Binds
    abstract fun provideAuthorizationInteractor(interactor: AuthorizationInteractor): IAuthorizationInteractor

    @Binds
    abstract fun provideMainnteractor(interactor: MainInteractor): IMainInteractor

}