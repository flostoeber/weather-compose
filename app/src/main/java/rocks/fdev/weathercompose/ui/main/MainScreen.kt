package rocks.fdev.weathercompose.ui.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import rocks.fdev.weathercompose.forecastCity
import rocks.fdev.weathercompose.hoursBetweenForecasts
import rocks.fdev.weathercompose.ui.forecast.ForecastDetailScreen
import rocks.fdev.weathercompose.ui.forecast.ForecastListScreen
import rocks.fdev.weathercompose.ui.forecast.ForecastViewModel

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val vm: ForecastViewModel = viewModel()

    NavHost(navController = navController, startDestination = Screen.Forecast.route) {

        composable(
            route = Screen.Forecast.route
        ) {
            ForecastListScreen(
                viewModel = vm,
                onItemClicked = { dt ->
                    navController.navigate("${Screen.DayDetails.route}/$dt")
                }
            )
        }

        composable(
            route = Screen.DayDetails.routeWithArgument,
            arguments = listOf(
                navArgument(Screen.DayDetails.argument0) { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val dt =
                backStackEntry.arguments?.getInt(Screen.DayDetails.argument0) ?: return@composable
            vm.selectDay(dt)

            ForecastDetailScreen(dt = dt, viewModel = vm) {
                navController.popBackStack(navController.graph.startDestination, false)
            }
        }

    }
}


sealed class Screen(val route: String) {
    object Forecast : Screen("/forecast")
    object DayDetails : Screen("/forecast/details") {
        const val routeWithArgument: String = "/forecast/details/{dt}"
        const val argument0: String = "dt"
    }
}
