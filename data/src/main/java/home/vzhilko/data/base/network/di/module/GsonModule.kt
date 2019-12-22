package home.vzhilko.data.base.network.di.module

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory

@Module
class GsonModule {

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory {
        val gson: Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        return GsonConverterFactory.create(gson)
    }

}