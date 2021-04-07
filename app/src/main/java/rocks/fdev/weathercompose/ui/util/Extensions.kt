package rocks.fdev.weathercompose.ui.util

import org.joda.time.DateTime

fun String.toOpenWeatherIconUrl(): String {
    return "https://openweathermap.org/img/wn/$this@2x.png"
}

fun Int.toShortDateTitle(): String {
    val dt = fromApiTime()
    return "${dt.dayOfWeek().asShortText}, ${dt.dayOfMonth}.${dt.monthOfYear}."
}

fun Int.fromApiTime(): DateTime {
    return DateTime(this * 1000L)
}
