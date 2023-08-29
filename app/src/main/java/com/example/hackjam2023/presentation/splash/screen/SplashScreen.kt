package com.example.hackjam2023.presentation.splash.screen

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hackjam2023.presentation.splash.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<SplashViewModel>()

    LaunchedEffect(key1 = true){
        viewModel.preCheck { isFirstTime ->
            if(isFirstTime){
                // Navigate to Onboard
            }else{
                // Navigate to Home
            }
        }
    }
}