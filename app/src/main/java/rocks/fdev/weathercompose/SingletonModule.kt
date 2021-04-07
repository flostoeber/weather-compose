package rocks.fdev.weathercompose

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import rocks.fdev.weathercompose.data.OpenWeatherApi
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class SingletonModule {

    @Singleton
    @Provides
    fun provideOpenWeatherApi(@ApplicationContext context: Context): OpenWeatherApi {
        val fiveMB = 5 * 1024 * 1024L
        val diskCache = Cache(context.cacheDir, fiveMB)
        val client = OkHttpClient.Builder()
            .addInterceptor(ChuckInterceptor(context))
            .cache(diskCache)
            .build()

        return Retrofit.Builder()
            .client(client)
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OpenWeatherApi::class.java)
    }

    @ExperimentalCoroutinesApi
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

}
