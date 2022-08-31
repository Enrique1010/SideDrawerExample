package com.erapps.navdrawerexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erapps.navdrawerexample.ui.screens.LandingPage
import com.erapps.navdrawerexample.ui.screens.SplashScreen

@Composable
fun MainGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavItem.SplashScreen.baseRoute) {
        composable(NavItem.SplashScreen.route){
            SplashScreen {
                navController.navigate(NavItem.LandingPage.baseRoute)
            }
        }
        composable(NavItem.LandingPage.route){
            LandingPage()
        }
    }
}