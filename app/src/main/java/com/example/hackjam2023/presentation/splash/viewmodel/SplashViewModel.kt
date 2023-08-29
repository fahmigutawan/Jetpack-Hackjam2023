package com.example.hackjam2023.presentation.splash.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hackjam2023.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: Repository
) :ViewModel(){
    fun preCheck(
        checked:(isFirstTime:Boolean) -> Unit
    ){
        viewModelScope.launch {
            delay(1500)
            checked(repository.getFirstTimeState().last())
        }
    }
}