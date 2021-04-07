package rocks.fdev.weathercompose.ui.forecast

import com.google.gson.Gson
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.joda.time.Hours
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.anyOrNull
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Response
import rocks.fdev.weathercompose.data.OpenWeatherApi
import rocks.fdev.weathercompose.fakeResponse
import rocks.fdev.weathercompose.hoursBetweenForecasts
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.model.WeatherForecast
import rocks.fdev.weathercompose.testutil.CoroutinesTestRule
import rocks.fdev.weathercompose.ui.InstantTaskExecutorRule
import rocks.fdev.weathercompose.ui.util.fromApiTime

@ExperimentalCoroutinesApi
class ForecastViewModelTest {

    @get:Rule(order = 0)
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule(order = 1)
    val coroutineRule = CoroutinesTestRule()

    private val api: OpenWeatherApi = mock()
    lateinit var sut: ForecastViewModel

    @Before
    fun setup() {
        sut = ForecastViewModel(coroutineRule.dispatcher, api)
        sut.forecast.observeForever {}
    }

    @Test
    fun `getWeatherFor fills livedata`() {
        runBlocking {
            givenFakeForecastResponse()
        }

        sut.getWeatherFor("fake", hoursBetweenForecasts)

        assertNotNull(sut.forecast.value)
    }

    @Test
    fun `getWeatherFor returns only entries with 8 hoursBetween`() {
        runBlocking {
            givenFakeForecastResponse()
        }

        sut.getWeatherFor("fake", 8)

        hasOnlyForecastsWith(sut.forecast.value!!, 8)
    }

    private fun hasOnlyForecastsWith(forecast: WeatherForecast, hoursBetween: Int) {
        var previous: Forecast? = null

        forecast.list.forEach { current ->
            val prev = previous
            if (prev != null) {
                assertHoursBetween(prev, current, hoursBetween)
            }

            previous = current
        }
    }

    private fun assertHoursBetween(first: Forecast, second: Forecast, hoursBetween: Int) {
        val firstDt = first.dt.fromApiTime()
        val secondDt = second.dt.fromApiTime()

        assertTrue(
            Hours.hoursBetween(firstDt, secondDt).isGreaterThan(Hours.hours(hoursBetween))
        )
    }

    private suspend fun givenFakeForecastResponse() {
        val fakeForecast = Gson().fromJson(fakeResponse, WeatherForecast::class.java)
        val fakeResponse = Response.success(fakeForecast)

        whenever(api.getForecast(anyOrNull(), anyOrNull(), anyOrNull())).thenReturn(fakeResponse)
    }

}
