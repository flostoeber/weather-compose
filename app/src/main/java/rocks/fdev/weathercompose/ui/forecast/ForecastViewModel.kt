package rocks.fdev.weathercompose.ui.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import org.joda.time.DateTime
import org.joda.time.Hours
import rocks.fdev.weathercompose.data.OpenWeatherApi
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.model.WeatherForecast
import rocks.fdev.weathercompose.ui.util.fromApiTime
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val ioDispatcher: CoroutineDispatcher,
    private val weatherApi: OpenWeatherApi
) : ViewModel() {

    private val _forecast = MutableLiveData<WeatherForecast?>()
    val forecast: LiveData<WeatherForecast?> = _forecast

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading

    private val _selectedForecastDay = MutableLiveData<Forecast?>()
    val selectedForecast: LiveData<Forecast?> = _selectedForecastDay

    private val _error = MutableLiveData<String>()
    val error = _error

    /**
     * Request a [WeatherForecast] containing forecasts that have a minimum time between them
     * @param city forecast location
     * @param hoursBetween minimum time between forecast items
     */
    fun getWeatherFor(city: String, hoursBetween: Int) {
        viewModelScope.launch(ioDispatcher) {
            isLoading.postValue(true)
            try {
                val response = weatherApi.getForecast(city = city)
                val weatherForecast = response.body()

                if (response.isSuccessful && weatherForecast != null) {
                    val reduced = weatherForecast.copy(
                        list = weatherForecast.list.reduceTo(
                            hoursBetween
                        )
                    )
                    _forecast.postValue(reduced)
                } else {
                    _error.postValue("Error: HttpCode(${response.code()})")
                }
            } catch (t: Throwable) {
                _error.postValue(t.message)
            }
            isLoading.postValue(false)
        }
    }

    /**
     * Request forecast details
     *
     * @param dt dt of selected forecast
     */
    fun selectDay(dt: Int) {
        // clear previous value since viewModel instance is kept for whole app
        _selectedForecastDay.value = null

        viewModelScope.launch {
            _isLoading.postValue(true)
            _forecast.value?.list?.firstOrNull { it.dt == dt }?.let { selectedDay ->
                _selectedForecastDay.postValue(selectedDay)
            }
            _isLoading.postValue(false)
        }
    }

    private fun List<Forecast>.reduceTo(hoursBetween: Int): List<Forecast> {
        val reducedResults = mutableListOf<Forecast>()

        var prev: Forecast? = null
        for (i in 0..this.lastIndex) {
            val curr = this[i]

            if (prev == null) {
                prev = curr
                reducedResults.add(curr)
            }

            val a = DateTime(prev.dt.fromApiTime())
            val b = DateTime(curr.dt.fromApiTime())
            if (Hours.hoursBetween(a, b).isGreaterThan(Hours.hours(hoursBetween))) {
                reducedResults.add(curr)
                prev = curr
            }
        }

        return reducedResults
    }

}
