package com.mad.real_estate_app.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class BottomBarItems(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarItems(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Tags : BottomBarItems(
        route = "tags",
        title = "Tags",
        icon = Icons.Default.Settings
    )

    object Search : BottomBarItems(
        route = "search",
        title = "Search",
        icon = Icons.Default.Search
    )

    object Profile : BottomBarItems(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}