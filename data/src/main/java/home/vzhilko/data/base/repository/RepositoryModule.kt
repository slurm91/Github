package home.vzhilko.data.base.repository

import dagger.Binds
import dagger.Module
import home.vzhilko.data.feature.auth.repository.AuthRepository
import home.vzhilko.data.feature.main.repository.MainRepository
import home.vzhilko.domain.base.repository.IAppRepository
import home.vzhilko.domain.base.scope.ApplicationScope
import home.vzhilko.domain.feature.auth.repository.IAuthRepository
import home.vzhilko.domain.feature.main.repository.IMainRepository

@Module
abstract class RepositoryModule {

    @ApplicationScope
    @Binds
    abstract fun provideAppRepository(repository: AppRepository): IAppRepository

    @Binds
    abstract fun provideAuthRepository(repository: AuthRepository): IAuthRepository

    @Binds
    abstract fun provideMainRepository(repository: MainRepository): IMainRepository

}