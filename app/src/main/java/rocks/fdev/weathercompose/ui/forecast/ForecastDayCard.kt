package rocks.fdev.weathercompose.ui.forecast

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateNext
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.glide.GlideImage
import org.joda.time.DateTime
import rocks.fdev.weathercompose.R
import rocks.fdev.weathercompose.model.Forecast
import rocks.fdev.weathercompose.timeFormatHoursMinutes
import rocks.fdev.weathercompose.ui.theme.OpenWeatherTheme
import rocks.fdev.weathercompose.ui.util.fromApiTime
import rocks.fdev.weathercompose.ui.util.loadFakeDayForecast
import rocks.fdev.weathercompose.ui.util.toOpenWeatherIconUrl

@Composable
fun ForecastDayCard(
    forecast: Forecast,
    onItemClicked: (Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable(
                onClick = { onItemClicked(forecast.dt) }
            ),
        color = MaterialTheme.colors.background,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val date = forecast.dt.fromApiTime()
            SimpleDateDisplay(date = date)
            SimpleTempDisplay(forecast = forecast)
        }
    }
}

@Composable
fun SimpleDateDisplay(date: DateTime) {
    Text(
        text = "${date.dayOfWeek().asShortText} ${date.monthOfYear().asShortText} ${date.dayOfMonth} ${
            date.toString(
                timeFormatHoursMinutes
            )
        }",
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun SimpleTempDisplay(forecast: Forecast) {
    val weather = forecast.weather.firstOrNull()

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = stringResource(
                id = R.string.temp_formatted_abs,
                forecast.main.temp
            ),
            style = MaterialTheme.typography.body1
        )
        if (weather != null) {
            GlideImage(
                data = weather.icon.toOpenWeatherIconUrl(),
                contentDescription = stringResource(id = R.string.cd_weather_icon),
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp)
            )
        }
        Icon(
            imageVector = Icons.Filled.NavigateNext,
            contentDescription = stringResource(R.string.cd_navigate_detail)
        )
    }
}

@Preview("ForeCastDay Card")
@Preview("ForeCastDay card dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ForeCastDayCardPreview() {
    OpenWeatherTheme {
        ForecastDayCard(forecast = loadFakeDayForecast()) {}
    }
}
