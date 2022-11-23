package com.mad.real_estate_app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mad.real_estate_app.util.DialogProvider

@Composable
fun Navigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ){
        composable(Routes.SignUpScreen.route){
            SignUpScreen(
                navController = navController
            )
        }
        composable(Routes.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(Routes.Home.route){

        }
        composable(Routes.LoginScreen.route){
            LoginScreen(navController = navController)
        }
    }
}