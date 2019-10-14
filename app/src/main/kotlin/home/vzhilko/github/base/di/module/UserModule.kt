package home.vzhilko.github.base.di.module

import dagger.Module
import dagger.Provides
import home.vzhilko.github.base.di.annotation.ActivityScope
import home.vzhilko.github.base.di.annotation.FragmentScope
import home.vzhilko.github.base.model.UserModel
import javax.inject.Named

@Module
class UserModule {

    @ActivityScope
    @Named("MainActivity")
    @Provides
    fun provideMainActivityUser(): UserModel {
        return UserModel("main", "1111")
    }

    @Provides
    @FragmentScope
    @Named("StartFragment")
    fun provideStartFragmentUser(): UserModel {
        return UserModel("start", "1111")
    }

    @Provides
    @FragmentScope
    @Named("TestFragment")
    fun provideTestFragmentUser(): UserModel {
        return UserModel("test", "1111")
    }

}