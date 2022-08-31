package com.erapps.navdrawerexample.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArgs> = emptyList()
) {
    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute).plus(argKeys).joinToString("/")
    }

    val args = navArgs.map { navArgument(name = it.key) { type = it.navType } }

    //main graph navigation
    object SplashScreen: NavItem("splash_screen")
    object LandingPage: NavItem("landing_page")

    //drawer graph navigation
    object Home: NavItem("home")
    object Store: NavItem("store")
    object Settings: NavItem("settings")
}

enum class NavArgs(val key: String, val navType: NavType<*>) {

}
