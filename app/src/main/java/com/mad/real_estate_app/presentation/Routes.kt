package com.mad.real_estate_app.presentation

sealed class Routes(val route: String){
    object LoginScreen : Routes("login_screen")
    object SignUpScreen : Routes("signup_screen")
    object SplashScreen: Routes("splash_screen")
    object Home: Routes("home_screen")
}
