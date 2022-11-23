package com.mad.real_estate_app.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mad.real_estate_app.screens.HomeScreen
import com.mad.real_estate_app.screens.ProfileScreen
import com.mad.real_estate_app.screens.TagsScreen
//import com.mad.real_estate_app.screens.SearchScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarItems.Home.route
    ) {
        composable(route = BottomBarItems.Home.route) {
            HomeScreen()
        }
        composable(route = BottomBarItems.Tags.route) {
            TagsScreen()
        }
//        composable(route = BottomBarItems.Search.route) {
//            SearchScreen()
//        }
        composable(route = BottomBarItems.Profile.route) {
            ProfileScreen()
        }
    }
}