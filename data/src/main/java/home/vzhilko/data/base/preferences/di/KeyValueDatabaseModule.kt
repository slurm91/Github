package home.vzhilko.data.base.preferences.di

import android.content.Context
import dagger.Module
import dagger.Provides
import home.vzhilko.data.base.preferences.IKeyValueDatabase
import home.vzhilko.data.base.preferences.KeyValueDatabase
import home.vzhilko.domain.base.scope.ApplicationScope

@Module
class KeyValueDatabaseModule {

    @ApplicationScope
    @Provides
    fun provideKeyValueDatabase(context: Context): IKeyValueDatabase {
        return KeyValueDatabase(context)
    }

}