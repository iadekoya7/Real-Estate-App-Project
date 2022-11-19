package com.mad.real_estate_app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen
    ){
        composable(Routes.SplashScreen){
            SplashScreen(navController = navController)
        }
        composable(Routes.Home){

        }
        composable(Routes.Login){
            LoginScreen(navController = navController)
        }
        composable(Routes.SignUp){

        }
    }
}