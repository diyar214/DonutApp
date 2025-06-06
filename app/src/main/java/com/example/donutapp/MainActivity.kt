package com.example.donutapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.donutapp.presentation.cartScreen.CartScreen
import com.example.donutapp.presentation.homeScreen.HomeScreen
import com.example.donutapp.presentation.onboardingScreen.OnboardingScreen
import com.example.donutapp.ui.theme.DonutAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            DonutAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screens.OnBoardingScreen.rout,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(
                            Screens.OnBoardingScreen.rout,
                        ) {
                            OnboardingScreen(navController)
                        }
                        composable(Screens.HomeScreen.rout) { HomeScreen(navController) }
                        composable(
                            route = "${Screens.CartScreen.rout}/{donutId}",
                            arguments = listOf(navArgument("donutId") { type = NavType.StringType })
                        ) { backStackEntry ->
                            val donutId = backStackEntry.arguments?.getString("donutId") ?: ""
                            CartScreen(navController, donutId)
                        }
                    }
                }
            }
        }
    }
}






