package rocks.fdev.weathercompose

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import retrofit2.Response
import rocks.fdev.weathercompose.data.OpenWeatherApi
import rocks.fdev.weathercompose.model.WeatherForecast

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [SingletonModule::class]
)
class FakeSingletonModule {

    @ExperimentalCoroutinesApi
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = TestCoroutineDispatcher()

    @Provides
    fun provideFakeWeatherApi(): OpenWeatherApi {
        val gson = Gson()

        return object : OpenWeatherApi {
            override suspend fun getForecast(
                city: String,
                units: OpenWeatherApi.Units,
                appId: String
            ): Response<WeatherForecast> {
                return Response.success(gson.fromJson(fakeResponse, WeatherForecast::class.java))
            }
        }
    }
}
