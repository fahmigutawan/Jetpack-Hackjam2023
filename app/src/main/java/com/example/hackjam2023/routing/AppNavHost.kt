package com.example.hackjam2023.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.hackjam2023.presentation.login.screen.LoginScreen
import com.example.hackjam2023.presentation.onboarding.screen.OnboardingScreen
import com.example.hackjam2023.presentation.register.screen.RegisterScreen
import com.example.hackjam2023.presentation.splash.screen.SplashScreen

@Composable
fun AppNavHost(
    modifier:Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NavRoutes.SPLASH.name
    ) {
        composable(route = NavRoutes.SPLASH.name) {
            SplashScreen(navController = navController)
        }

        composable(route = NavRoutes.LOGIN.name) {
            LoginScreen(navController = navController)
        }

        composable(route = NavRoutes.REGISTER.name) {
            RegisterScreen(navController = navController)
        }

        composable(route = NavRoutes.ONBOARDING.name) {
            OnboardingScreen(navController = navController)
        }
    }
}