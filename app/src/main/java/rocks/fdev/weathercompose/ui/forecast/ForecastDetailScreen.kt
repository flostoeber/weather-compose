package rocks.fdev.weathercompose.ui.forecast

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import rocks.fdev.weathercompose.R
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.model.WeatherForecast
import rocks.fdev.weathercompose.timeFormatHoursMinutes
import rocks.fdev.weathercompose.ui.theme.OpenWeatherTheme
import rocks.fdev.weathercompose.ui.util.LoadingContentDisplay
import rocks.fdev.weathercompose.ui.util.fromApiTime
import rocks.fdev.weathercompose.ui.util.loadFakeWeatherForecast

/**
 * Shows details for a given forecast dt
 *
 * @param dt identifies a specific forecast
 * @param viewModel shared ViewModel for this screen
 * @param onBack trigger back navigation
 */
@Composable
fun ForecastDetailScreen(
    dt: Int,
    viewModel: ForecastViewModel,
    onBack: () -> Unit
) {
    val date = dt.fromApiTime()
    val forecast by viewModel.forecast.observeAsState(null)
    val forecastDay by viewModel.selectedForecast.observeAsState(null)
    val isLoading by viewModel.isLoading.observeAsState(true)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "${date.dayOfWeek().asShortText} ${date.monthOfYear().asShortText} ${date.dayOfMonth} ${
                            date.toString(
                                timeFormatHoursMinutes
                            )
                        }"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.cd_navigate_up)
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)

            LoadingContentDisplay(isLoading = isLoading, modifier = modifier) {
                ForecastDetailScreenContent(
                    forecast = forecast,
                    forecastDay = forecastDay,
                    modifier = modifier
                )
            }
        }
    )
}

@Composable
fun ForecastDetailScreenContent(
    forecast: WeatherForecast?,
    forecastDay: Forecast?,
    modifier: Modifier
) {
    if (forecast != null && forecastDay != null) {
        ForecastDetailCard(forecast = forecast, dayForecast = forecastDay, modifier = modifier)
    }
}

@Preview("Forecast Detail screen")
@Preview("Forecast Detail screen darkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewForecastDetailScreen() {
    val forecast = loadFakeWeatherForecast()
    val forecastDay = forecast.list.first()
    OpenWeatherTheme {
        ForecastDetailScreenContent(forecast = forecast, forecastDay = forecastDay, Modifier)
    }
}
