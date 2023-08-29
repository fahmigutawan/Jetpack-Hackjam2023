package com.example.hackjam2023.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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

        }

        composable(route = NavRoutes.LOGIN.name) {

        }

        composable(route = NavRoutes.REGISTER.name) {

        }

        composable(route = NavRoutes.ONBOARDING.name) {

        }
    }
}