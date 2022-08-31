package com.erapps.navdrawerexample.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            imageVector = Icons.Default.Home,
            modifier = modifier.size(64.dp, 64.dp),
            alignment = Alignment.Center,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
            contentDescription = null
        )
        Spacer(modifier = modifier.height(4.dp))
        Text(text = "Home", fontSize = 30.sp)
    }
}