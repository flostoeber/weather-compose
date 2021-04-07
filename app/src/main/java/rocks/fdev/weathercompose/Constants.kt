package rocks.fdev.weathercompose

const val forecastCity = "berlin"
const val hoursBetweenForecasts = 8
const val timeFormatHoursMinutes = "HH:mm"
const val apiBaseUrl = "https://api.openweathermap.org/"
const val fakeResponse = """
    {
    "cod": "200",
    "message": 0,
    "cnt": 40,
    "list": [
        {
            "dt": 1616166000,
            "main": {
                "temp": 3.89,
                "feels_like": -3.74,
                "temp_min": 3.29,
                "temp_max": 3.89,
                "pressure": 1022,
                "sea_level": 1022,
                "grnd_level": 1017,
                "humidity": 57,
                "temp_kf": 0.6
            },
            "weather": [
                {
                    "id": 600,
                    "main": "Snow",
                    "description": "light snow",
                    "icon": "13d"
                }
            ],
            "clouds": {
                "all": 47
            },
            "wind": {
                "speed": 7.35,
                "deg": 23
            },
            "visibility": 10000,
            "pop": 0.61,
            "snow": {
                "3h": 0.26
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-19 15:00:00"
        },
        {
            "dt": 1616176800,
            "main": {
                "temp": 0.64,
                "feels_like": -6.54,
                "temp_min": -0.42,
                "temp_max": 0.64,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1019,
                "humidity": 55,
                "temp_kf": 1.06
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 39
            },
            "wind": {
                "speed": 6.2,
                "deg": 23
            },
            "visibility": 10000,
            "pop": 0.42,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-19 18:00:00"
        },
        {
            "dt": 1616187600,
            "main": {
                "temp": -1.23,
                "feels_like": -7.36,
                "temp_min": -1.62,
                "temp_max": -1.23,
                "pressure": 1027,
                "sea_level": 1027,
                "grnd_level": 1022,
                "humidity": 58,
                "temp_kf": 0.39
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 2
            },
            "wind": {
                "speed": 4.57,
                "deg": 30
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-19 21:00:00"
        },
        {
            "dt": 1616198400,
            "main": {
                "temp": -1.91,
                "feels_like": -6.97,
                "temp_min": -1.96,
                "temp_max": -1.91,
                "pressure": 1028,
                "sea_level": 1028,
                "grnd_level": 1023,
                "humidity": 61,
                "temp_kf": 0.05
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3.04,
                "deg": 17
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-20 00:00:00"
        },
        {
            "dt": 1616209200,
            "main": {
                "temp": -2.13,
                "feels_like": -7.04,
                "temp_min": -2.13,
                "temp_max": -2.13,
                "pressure": 1028,
                "sea_level": 1028,
                "grnd_level": 1023,
                "humidity": 65,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 49
            },
            "wind": {
                "speed": 2.9,
                "deg": 351
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-20 03:00:00"
        },
        {
            "dt": 1616220000,
            "main": {
                "temp": -1.68,
                "feels_like": -6.34,
                "temp_min": -1.68,
                "temp_max": -1.68,
                "pressure": 1029,
                "sea_level": 1029,
                "grnd_level": 1023,
                "humidity": 67,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 54
            },
            "wind": {
                "speed": 2.65,
                "deg": 6
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-20 06:00:00"
        },
        {
            "dt": 1616230800,
            "main": {
                "temp": 0.89,
                "feels_like": -4.15,
                "temp_min": 0.89,
                "temp_max": 0.89,
                "pressure": 1029,
                "sea_level": 1029,
                "grnd_level": 1023,
                "humidity": 49,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 74
            },
            "wind": {
                "speed": 2.99,
                "deg": 318
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-20 09:00:00"
        },
        {
            "dt": 1616241600,
            "main": {
                "temp": 3.61,
                "feels_like": -1.4,
                "temp_min": 3.61,
                "temp_max": 3.61,
                "pressure": 1028,
                "sea_level": 1028,
                "grnd_level": 1022,
                "humidity": 38,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 83
            },
            "wind": {
                "speed": 2.86,
                "deg": 292
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-20 12:00:00"
        },
        {
            "dt": 1616252400,
            "main": {
                "temp": 4.6,
                "feels_like": -0.91,
                "temp_min": 4.6,
                "temp_max": 4.6,
                "pressure": 1025,
                "sea_level": 1025,
                "grnd_level": 1020,
                "humidity": 37,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 801,
                    "main": "Clouds",
                    "description": "few clouds",
                    "icon": "02d"
                }
            ],
            "clouds": {
                "all": 11
            },
            "wind": {
                "speed": 3.64,
                "deg": 273
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-20 15:00:00"
        },
        {
            "dt": 1616263200,
            "main": {
                "temp": 2.22,
                "feels_like": -3.17,
                "temp_min": 2.22,
                "temp_max": 2.22,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1019,
                "humidity": 48,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 40
            },
            "wind": {
                "speed": 3.61,
                "deg": 247
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-20 18:00:00"
        },
        {
            "dt": 1616274000,
            "main": {
                "temp": 2.36,
                "feels_like": -4.11,
                "temp_min": 2.36,
                "temp_max": 2.36,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 50,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 99
            },
            "wind": {
                "speed": 5.24,
                "deg": 247
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-20 21:00:00"
        },
        {
            "dt": 1616284800,
            "main": {
                "temp": 2.41,
                "feels_like": -4.15,
                "temp_min": 2.41,
                "temp_max": 2.41,
                "pressure": 1020,
                "sea_level": 1020,
                "grnd_level": 1015,
                "humidity": 65,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 99
            },
            "wind": {
                "speed": 5.88,
                "deg": 246
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-21 00:00:00"
        },
        {
            "dt": 1616295600,
            "main": {
                "temp": 2.97,
                "feels_like": -3.12,
                "temp_min": 2.97,
                "temp_max": 2.97,
                "pressure": 1017,
                "sea_level": 1017,
                "grnd_level": 1011,
                "humidity": 80,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 100
            },
            "wind": {
                "speed": 5.84,
                "deg": 260
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-21 03:00:00"
        },
        {
            "dt": 1616306400,
            "main": {
                "temp": 3.9,
                "feels_like": -1.57,
                "temp_min": 3.9,
                "temp_max": 3.9,
                "pressure": 1014,
                "sea_level": 1014,
                "grnd_level": 1009,
                "humidity": 91,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 100
            },
            "wind": {
                "speed": 5.56,
                "deg": 274
            },
            "visibility": 10000,
            "pop": 0.28,
            "rain": {
                "3h": 0.65
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-21 06:00:00"
        },
        {
            "dt": 1616317200,
            "main": {
                "temp": 6.34,
                "feels_like": 0.62,
                "temp_min": 6.34,
                "temp_max": 6.34,
                "pressure": 1014,
                "sea_level": 1014,
                "grnd_level": 1009,
                "humidity": 72,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
                }
            ],
            "clouds": {
                "all": 100
            },
            "wind": {
                "speed": 5.7,
                "deg": 299
            },
            "visibility": 10000,
            "pop": 0.43,
            "rain": {
                "3h": 0.25
            },
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-21 09:00:00"
        },
        {
            "dt": 1616328000,
            "main": {
                "temp": 6.5,
                "feels_like": 0.32,
                "temp_min": 6.5,
                "temp_max": 6.5,
                "pressure": 1014,
                "sea_level": 1014,
                "grnd_level": 1008,
                "humidity": 63,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 94
            },
            "wind": {
                "speed": 5.99,
                "deg": 303
            },
            "visibility": 10000,
            "pop": 0.29,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-21 12:00:00"
        },
        {
            "dt": 1616338800,
            "main": {
                "temp": 7.58,
                "feels_like": 2.66,
                "temp_min": 7.58,
                "temp_max": 7.58,
                "pressure": 1014,
                "sea_level": 1014,
                "grnd_level": 1008,
                "humidity": 60,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 99
            },
            "wind": {
                "speed": 4.26,
                "deg": 314
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-21 15:00:00"
        },
        {
            "dt": 1616349600,
            "main": {
                "temp": 5.71,
                "feels_like": 1.97,
                "temp_min": 5.71,
                "temp_max": 5.71,
                "pressure": 1015,
                "sea_level": 1015,
                "grnd_level": 1010,
                "humidity": 74,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 96
            },
            "wind": {
                "speed": 2.82,
                "deg": 326
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-21 18:00:00"
        },
        {
            "dt": 1616360400,
            "main": {
                "temp": 2.81,
                "feels_like": -0.87,
                "temp_min": 2.81,
                "temp_max": 2.81,
                "pressure": 1017,
                "sea_level": 1017,
                "grnd_level": 1012,
                "humidity": 70,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 73
            },
            "wind": {
                "speed": 2.01,
                "deg": 13
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-21 21:00:00"
        },
        {
            "dt": 1616371200,
            "main": {
                "temp": 1.11,
                "feels_like": -3.12,
                "temp_min": 1.11,
                "temp_max": 1.11,
                "pressure": 1018,
                "sea_level": 1018,
                "grnd_level": 1012,
                "humidity": 65,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 49
            },
            "wind": {
                "speed": 2.35,
                "deg": 352
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-22 00:00:00"
        },
        {
            "dt": 1616382000,
            "main": {
                "temp": 0.23,
                "feels_like": -3.57,
                "temp_min": 0.23,
                "temp_max": 0.23,
                "pressure": 1018,
                "sea_level": 1018,
                "grnd_level": 1013,
                "humidity": 67,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 39
            },
            "wind": {
                "speed": 1.67,
                "deg": 331
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-22 03:00:00"
        },
        {
            "dt": 1616392800,
            "main": {
                "temp": 0.53,
                "feels_like": -3.52,
                "temp_min": 0.53,
                "temp_max": 0.53,
                "pressure": 1020,
                "sea_level": 1020,
                "grnd_level": 1014,
                "humidity": 64,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03d"
                }
            ],
            "clouds": {
                "all": 45
            },
            "wind": {
                "speed": 1.98,
                "deg": 287
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-22 06:00:00"
        },
        {
            "dt": 1616403600,
            "main": {
                "temp": 5.4,
                "feels_like": 0.93,
                "temp_min": 5.4,
                "temp_max": 5.4,
                "pressure": 1021,
                "sea_level": 1021,
                "grnd_level": 1015,
                "humidity": 44,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 67
            },
            "wind": {
                "speed": 2.53,
                "deg": 301
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-22 09:00:00"
        },
        {
            "dt": 1616414400,
            "main": {
                "temp": 8.42,
                "feels_like": 3.36,
                "temp_min": 8.42,
                "temp_max": 8.42,
                "pressure": 1021,
                "sea_level": 1021,
                "grnd_level": 1015,
                "humidity": 35,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 83
            },
            "wind": {
                "speed": 3.33,
                "deg": 316
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-22 12:00:00"
        },
        {
            "dt": 1616425200,
            "main": {
                "temp": 8.91,
                "feels_like": 4.43,
                "temp_min": 8.91,
                "temp_max": 8.91,
                "pressure": 1021,
                "sea_level": 1021,
                "grnd_level": 1015,
                "humidity": 37,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 83
            },
            "wind": {
                "speed": 2.67,
                "deg": 331
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-22 15:00:00"
        },
        {
            "dt": 1616436000,
            "main": {
                "temp": 5.43,
                "feels_like": 2.25,
                "temp_min": 5.43,
                "temp_max": 5.43,
                "pressure": 1021,
                "sea_level": 1021,
                "grnd_level": 1016,
                "humidity": 55,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 87
            },
            "wind": {
                "speed": 1.15,
                "deg": 54
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-22 18:00:00"
        },
        {
            "dt": 1616446800,
            "main": {
                "temp": 3.29,
                "feels_like": -0.48,
                "temp_min": 3.29,
                "temp_max": 3.29,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1018,
                "humidity": 57,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 42
            },
            "wind": {
                "speed": 1.75,
                "deg": 175
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-22 21:00:00"
        },
        {
            "dt": 1616457600,
            "main": {
                "temp": 2.22,
                "feels_like": -1.18,
                "temp_min": 2.22,
                "temp_max": 2.22,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 76,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 27
            },
            "wind": {
                "speed": 1.71,
                "deg": 233
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-23 00:00:00"
        },
        {
            "dt": 1616468400,
            "main": {
                "temp": 1.3,
                "feels_like": -2.19,
                "temp_min": 1.3,
                "temp_max": 1.3,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 87,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.02,
                "deg": 249
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-23 03:00:00"
        },
        {
            "dt": 1616479200,
            "main": {
                "temp": 1.21,
                "feels_like": -2.79,
                "temp_min": 1.21,
                "temp_max": 1.21,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 86,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 1
            },
            "wind": {
                "speed": 2.7,
                "deg": 272
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-23 06:00:00"
        },
        {
            "dt": 1616490000,
            "main": {
                "temp": 6.31,
                "feels_like": 2.42,
                "temp_min": 6.31,
                "temp_max": 6.31,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 67,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 86
            },
            "wind": {
                "speed": 2.85,
                "deg": 277
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-23 09:00:00"
        },
        {
            "dt": 1616500800,
            "main": {
                "temp": 8.22,
                "feels_like": 3.96,
                "temp_min": 8.22,
                "temp_max": 8.22,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 68,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 89
            },
            "wind": {
                "speed": 3.86,
                "deg": 297
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-23 12:00:00"
        },
        {
            "dt": 1616511600,
            "main": {
                "temp": 8.62,
                "feels_like": 4.25,
                "temp_min": 8.62,
                "temp_max": 8.62,
                "pressure": 1022,
                "sea_level": 1022,
                "grnd_level": 1017,
                "humidity": 68,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04d"
                }
            ],
            "clouds": {
                "all": 95
            },
            "wind": {
                "speed": 4.11,
                "deg": 295
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-23 15:00:00"
        },
        {
            "dt": 1616522400,
            "main": {
                "temp": 7.03,
                "feels_like": 3.26,
                "temp_min": 7.03,
                "temp_max": 7.03,
                "pressure": 1023,
                "sea_level": 1023,
                "grnd_level": 1017,
                "humidity": 82,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 804,
                    "main": "Clouds",
                    "description": "overcast clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 94
            },
            "wind": {
                "speed": 3.55,
                "deg": 281
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-23 18:00:00"
        },
        {
            "dt": 1616533200,
            "main": {
                "temp": 6.5,
                "feels_like": 2.87,
                "temp_min": 6.5,
                "temp_max": 6.5,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1018,
                "humidity": 85,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 803,
                    "main": "Clouds",
                    "description": "broken clouds",
                    "icon": "04n"
                }
            ],
            "clouds": {
                "all": 80
            },
            "wind": {
                "speed": 3.35,
                "deg": 283
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-23 21:00:00"
        },
        {
            "dt": 1616544000,
            "main": {
                "temp": 4.62,
                "feels_like": 1.05,
                "temp_min": 4.62,
                "temp_max": 4.62,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1018,
                "humidity": 89,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 802,
                    "main": "Clouds",
                    "description": "scattered clouds",
                    "icon": "03n"
                }
            ],
            "clouds": {
                "all": 47
            },
            "wind": {
                "speed": 2.94,
                "deg": 273
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-24 00:00:00"
        },
        {
            "dt": 1616554800,
            "main": {
                "temp": 3.58,
                "feels_like": -0.08,
                "temp_min": 3.58,
                "temp_max": 3.58,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1018,
                "humidity": 92,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01n"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 2.94,
                "deg": 280
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "n"
            },
            "dt_txt": "2021-03-24 03:00:00"
        },
        {
            "dt": 1616565600,
            "main": {
                "temp": 3.38,
                "feels_like": -0.17,
                "temp_min": 3.38,
                "temp_max": 3.38,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1019,
                "humidity": 91,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 1
            },
            "wind": {
                "speed": 2.69,
                "deg": 287
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-24 06:00:00"
        },
        {
            "dt": 1616576400,
            "main": {
                "temp": 8.53,
                "feels_like": 4.9,
                "temp_min": 8.53,
                "temp_max": 8.53,
                "pressure": 1025,
                "sea_level": 1025,
                "grnd_level": 1019,
                "humidity": 70,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 0
            },
            "wind": {
                "speed": 3.13,
                "deg": 297
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-24 09:00:00"
        },
        {
            "dt": 1616587200,
            "main": {
                "temp": 12.1,
                "feels_like": 8.4,
                "temp_min": 12.1,
                "temp_max": 12.1,
                "pressure": 1024,
                "sea_level": 1024,
                "grnd_level": 1019,
                "humidity": 55,
                "temp_kf": 0
            },
            "weather": [
                {
                    "id": 800,
                    "main": "Clear",
                    "description": "clear sky",
                    "icon": "01d"
                }
            ],
            "clouds": {
                "all": 1
            },
            "wind": {
                "speed": 3.22,
                "deg": 294
            },
            "visibility": 10000,
            "pop": 0,
            "sys": {
                "pod": "d"
            },
            "dt_txt": "2021-03-24 12:00:00"
        }
    ],
    "city": {
        "id": 2950159,
        "name": "Berlin",
        "coord": {
            "lat": 52.5244,
            "lon": 13.4105
        },
        "country": "DE",
        "population": 1000000,
        "timezone": 3600,
        "sunrise": 1616130672,
        "sunset": 1616174221
    }
}
"""
