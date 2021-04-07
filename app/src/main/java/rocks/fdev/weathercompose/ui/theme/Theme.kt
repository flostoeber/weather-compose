package rocks.fdev.weathercompose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightThemeColors = lightColors(
    primary = yellow_700,
    secondary = yellow_500,
    error = Color.Red,
    background = Color.White
)

private val DarkThemeColors = darkColors(
    primary = yellow_700,
    secondary = yellow_500,
    error = Color.Red,
    background = anthracite
)

@Composable
fun OpenWeatherTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        content = content
    )
}
