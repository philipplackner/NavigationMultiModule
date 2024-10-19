package com.plcoding.navigationmultimoduleprep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.plcoding.feature_a.presentation.ScreenA
import com.plcoding.feature_a.presentation.ScreenB
import com.plcoding.feature_b.presentation.ScreenC
import com.plcoding.navigation.Route
import com.plcoding.navigationmultimoduleprep.ui.theme.NavigationMultiModulePrepTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationMultiModulePrepTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Route.ScreenA
                    ) {
                        composable<Route.ScreenA> {
                            ScreenA(
                                onButtonClick = {
                                    navController.navigate(Route.ScreenB)
                                }
                            )
                        }
                        composable<Route.ScreenB> {
                            ScreenB(
                                onButtonClick = {
                                    navController.navigate(Route.ScreenC)
                                }
                            )
                        }
                        composable<Route.ScreenC> {
                            ScreenC(
                                onButtonClick = {
                                    navController.navigate(Route.ScreenA) {
                                        popUpTo<Route.ScreenC> {
                                            inclusive = true
                                        }
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavigationMultiModulePrepTheme {
        Greeting("Android")
    }
}