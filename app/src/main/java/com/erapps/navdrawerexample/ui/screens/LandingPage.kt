package com.erapps.navdrawerexample.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.erapps.navdrawerexample.R
import com.erapps.navdrawerexample.ui.navigation.DrawerNavGraph
import com.erapps.navdrawerexample.ui.navigation.NavItem
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val items = listOf(
        SideMenuItem(
            route = NavItem.Home.route,
            title = "Home",
            imageVector = Icons.Default.Home
        ),
        SideMenuItem(
            route = NavItem.Store.route,
            title = "Store",
            imageVector = Icons.Default.ShoppingCart
        ),
        SideMenuItem(
            route = NavItem.Settings.route,
            title = "Settings",
            imageVector = Icons.Default.Settings
        )
    )

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopBar {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerContent = {
            DrawerHeader()
            DrawerBody(items = items) {
                scope.launch { scaffoldState.drawerState.close() }
                navController.navigate(it.route) {
                    navController.graph.startDestinationRoute?.let { screen_route ->
                        popUpTo(screen_route) {
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    ) {
        DrawerNavGraph(navController)
    }
}

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onNavigationItemClick: () -> Unit
) {
    TopAppBar(
        title = { Text(text = "NDE") },
        modifier = modifier,
        navigationIcon = {
            IconButton(
                onClick = { onNavigationItemClick() }
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = ""
                )
            }
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}

@Composable
private fun DrawerHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.primary),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_drawer_icon),
                modifier = modifier.size(64.dp, 64.dp),
                alignment = Alignment.Center,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onPrimary),
                contentDescription = null
            )
            Spacer(modifier = modifier.height(4.dp))
            Text(text = "NDE", fontSize = 30.sp, color = MaterialTheme.colors.onPrimary)
        }
    }
}

@Composable
private fun DrawerBody(
    modifier: Modifier = Modifier,
    items: List<SideMenuItem>,
    onItemClick: (SideMenuItem) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(item) }
                    .padding(16.dp)
            ) {
                Icon(imageVector = item.imageVector, contentDescription = item.title)
                Spacer(modifier = modifier.width(16.dp))
                Text(text = item.title, modifier = modifier.weight(1f))
            }
        }
    }
}