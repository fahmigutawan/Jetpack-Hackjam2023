package com.example.hackjam2023.presentation.register.screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hackjam2023.presentation.register.viewmodel.RegisterViewModel

@Composable
fun RegisterScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<RegisterViewModel>()
}