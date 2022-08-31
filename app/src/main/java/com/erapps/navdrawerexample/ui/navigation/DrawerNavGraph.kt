package com.erapps.navdrawerexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.erapps.navdrawerexample.ui.screens.home.HomeScreen
import com.erapps.navdrawerexample.ui.screens.settings.SettingsScreen
import com.erapps.navdrawerexample.ui.screens.store.StoreScreen

@Composable
fun DrawerNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = NavItem.Home.baseRoute){
        composable(NavItem.Home){
            HomeScreen()
        }
        composable(NavItem.Store){
            StoreScreen()
        }
        composable(NavItem.Settings){
            SettingsScreen()
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(route = navItem.route, arguments = navItem.args) {
        content(it)
    }
}