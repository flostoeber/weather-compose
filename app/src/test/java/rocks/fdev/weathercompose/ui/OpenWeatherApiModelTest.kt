package rocks.fdev.weathercompose.ui

import com.google.gson.Gson
import org.junit.Assert.assertTrue
import org.junit.Test
import rocks.fdev.weathercompose.fakeResponse
import rocks.fdev.weathercompose.model.WeatherForecast

class OpenWeatherApiModelTest {

    @Test
    fun canParseResponse() {
        val model = Gson().fromJson(fakeResponse, WeatherForecast::class.java)
        assertTrue(model != null)
    }

}
