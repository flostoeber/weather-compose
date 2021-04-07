package rocks.fdev.weathercompose.ui.forecast

import android.content.res.Configuration
import android.text.Editable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import rocks.fdev.weathercompose.R
import rocks.fdev.weathercompose.forecastCity
import rocks.fdev.weathercompose.hoursBetweenForecasts
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.ui.theme.OpenWeatherTheme
import rocks.fdev.weathercompose.ui.util.LoadingContentDisplay
import rocks.fdev.weathercompose.ui.util.loadFakeWeatherForecast

/**
 * Fetches forecast data for a city and displays the results in a list
 *
 * @param viewModel shared ViewModel for this screen
 * @param onItemClicked called when an item has been clicked
 */
@Composable
fun ForecastListScreen(
    viewModel: ForecastViewModel,
    onItemClicked: (Int) -> Unit
) {
    val forecast by viewModel.forecast.observeAsState(null)
    val isLoading by viewModel.isLoading.observeAsState(true)
    viewModel.getWeatherFor(city = forecastCity, hoursBetween = hoursBetweenForecasts)

    Scaffold(
        topBar = {
            val title = stringResource(id = R.string.app_name)
            TopAppBar(
                title = { Text(text = title) }
            )
        },
        content = { innerPadding ->
            val modifier = Modifier.padding(innerPadding)
            Column(
                horizontalAlignment = Alignment.Companion.CenterHorizontally,
                modifier = modifier
            ) {
                LoadingContentDisplay(isLoading = isLoading, modifier = modifier) {
                    ForecastList(forecast?.list, onItemClicked, modifier)
                }
            }
        }
    )
}

@Composable
private fun ForecastList(
    forecasts: List<Forecast>?,
    onItemClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        forecasts?.forEach { dayForecast ->
            item {
                ForecastDayCard(forecast = dayForecast, onItemClicked)
            }
        }
    }

}

@Preview("Forecast screen")
@Preview("Forecast screen darkMode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewForecastScreen() {
    OpenWeatherTheme {
        Scaffold {
            ForecastList(loadFakeWeatherForecast().list, { })
        }
    }
}
