package com.example.coopbank.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coopbank.ui.screens.home.HomeScreen
import com.example.coopbank.ui.screens.login.LoginScreen
import com.example.coopbank.ui.screens.login.LoginViewModel
@ExperimentalComposeUiApi
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "login" ){

        composable("home_screen") {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            HomeScreen(navController = navController, viewModel = loginViewModel)
        }
        composable("login") {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginScreen(navController = navController,viewModel=loginViewModel)
        }
    }

}