package rocks.fdev.weathercompose.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import rocks.fdev.weathercompose.apiKey
import rocks.fdev.weathercompose.model.WeatherForecast

interface OpenWeatherApi {

    enum class Units {
        metric, imperial
    }

    @GET("/data/2.5/forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("units") units: Units = Units.metric,
        @Query("appid") appId: String = apiKey
    ): Response<WeatherForecast>

}
