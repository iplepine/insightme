package com.jyoon.insightme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jyoon.core.compose.compositionlocal.LoggerCompositionLocal
import com.jyoon.core.compose.expect.getLogger
import com.jyoon.insightme.feature.main.MainScreen
import com.jyoon.insightme.feature.sleeptracker.SleepTrackerScreen
import kotlinx.serialization.Serializable
import org.jetbrains.compose.ui.tooling.preview.Preview

@Serializable
object ListDestination

@Serializable
data class DetailDestination(val objectId: Int)

@Composable
@Preview
fun App() {
    CompositionLocalProvider(LoggerCompositionLocal provides getLogger()) {
        MaterialTheme(
            colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
        ) {
            Surface {
                val navController: NavHostController = rememberNavController()

                NavHost(navController = navController, startDestination = ListDestination) {
                    composable<ListDestination> {
                        MainScreen(
                            navigateToDetails = { objectId ->
                                navController.navigate(DetailDestination(objectId))
                            }
                        )
                    }
                    composable<DetailDestination> { backStackEntry ->
                        SleepTrackerScreen(
                            objectId = backStackEntry.toRoute<DetailDestination>().objectId,
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}