package rocks.fdev.weathercompose.ui.util

import androidx.compose.runtime.Composable
import com.google.gson.Gson
import rocks.fdev.weathercompose.fakeResponse
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.model.WeatherForecast

@Composable
fun loadFakeWeatherForecast(): WeatherForecast {
    return Gson().fromJson(fakeResponse, WeatherForecast::class.java)
}

@Composable
fun loadFakeDayForecast(): Forecast {
    return loadFakeWeatherForecast().list.first()
}
