package rocks.fdev.weathercompose.ui.forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.North
import androidx.compose.material.icons.filled.South
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import org.joda.time.DateTime
import rocks.fdev.weathercompose.R
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.model.Weather
import rocks.fdev.weathercompose.model.WeatherForecast
import rocks.fdev.weathercompose.timeFormatHoursMinutes
import rocks.fdev.weathercompose.ui.util.fromApiTime
import rocks.fdev.weathercompose.ui.util.loadFakeWeatherForecast
import rocks.fdev.weathercompose.ui.util.toOpenWeatherIconUrl

@Composable
fun ForecastDetailCard(
    forecast: WeatherForecast,
    dayForecast: Forecast,
    modifier: Modifier
) {
    val sunrise = forecast.city.sunrise.fromApiTime()
    val sunset = forecast.city.sunset.fromApiTime()

    Column(
        modifier = modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        ProminentTempWeather(forecast = dayForecast, weather = dayForecast.weather.first())
        SunDetails(sunrise = sunrise, sunset = sunset)
        StackedDetails(forecast = dayForecast)
    }
}

@Composable
fun ProminentTempWeather(forecast: Forecast, weather: Weather) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        GlideImage(
            data = weather.icon.toOpenWeatherIconUrl(),
            contentDescription = stringResource(id = R.string.cd_weather_icon),
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.temp_formatted_abs, forecast.main.temp),
                style = MaterialTheme.typography.h4
            )
            if (forecast.main.temp > 15) {
                Text(text = stringResource(id = R.string.temp_hot), color = Color.Red)
            } else if (forecast.main.temp < 10) {
                Text(text = stringResource(id = R.string.temp_cold), color = Color.Blue)
            }
        }
    }
}

@Composable
fun SunDetails(sunrise: DateTime, sunset: DateTime) {
    Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        SunriseAt(date = sunrise)
        SunsetAt(date = sunset)
    }
}

@Composable
fun SunriseAt(date: DateTime) {
    Row {
        Icon(
            imageVector = Icons.Filled.North,
            contentDescription = stringResource(R.string.cd_navigate_up)
        )
        Icon(
            imageVector = Icons.Filled.LightMode,
            contentDescription = stringResource(R.string.cd_navigate_up)
        )
        Text(text = date.toString(timeFormatHoursMinutes), style = MaterialTheme.typography.body1)
    }
}

@Composable
fun SunsetAt(date: DateTime) {
    Row {
        Icon(
            imageVector = Icons.Filled.South,
            contentDescription = stringResource(R.string.cd_navigate_up)
        )
        Icon(
            imageVector = Icons.Filled.LightMode,
            contentDescription = stringResource(R.string.cd_navigate_up)
        )
        Text(text = date.toString(timeFormatHoursMinutes), style = MaterialTheme.typography.body1)
    }
}

@Composable
fun StackDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 4.dp, vertical = 12.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
fun StackedDetails(forecast: Forecast) {
    Column(modifier = Modifier.fillMaxWidth()) {

        StackDivider()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.rain))
            val rain = forecast.rain
            if (rain != null) {
                Text(
                    text = stringResource(
                        id = R.string.rain_formatted,
                        forecast.rain.h3
                    )
                )
            } else {
                Text(text = stringResource(id = R.string.placeholder_empty))
            }
        }

        StackDivider()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.humidity))
            Text(text = "${forecast.main.humidity}%")
        }

        StackDivider()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.pressure))
            Text(
                text = stringResource(
                    id = R.string.pressure_formatted,
                    forecast.main.pressure
                )
            )
        }

        StackDivider()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.wind_speed))
            Text(
                text = stringResource(
                    id = R.string.wind_speed_formatted,
                    forecast.wind.speed
                )
            )
        }

        StackDivider()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.wind_direction))
            Text(
                text = stringResource(
                    id = R.string.wind_direction_formatted,
                    forecast.wind.deg
                )
            )
        }
    }
}

@Preview("DayDetailCard Preview")
@Composable
fun PreviewDayDetail() {
    val forecast = loadFakeWeatherForecast()
    val forecastDay = forecast.list.first()

    ForecastDetailCard(
        forecast = loadFakeWeatherForecast(),
        dayForecast = forecastDay,
        modifier = Modifier
    )
}
