package com.example.hackjam2023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.hackjam2023.routing.AppNavHost
import com.example.hackjam2023.ui.theme.Hackjam2023Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val mainViewModel by viewModels<MainViewModel>()
            val navController = rememberNavController()

            Hackjam2023Theme {
                Scaffold {
                    AppNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                bottom = it.calculateBottomPadding()
                            ),
                        navController = navController
                    )
                }
            }
        }
    }
}