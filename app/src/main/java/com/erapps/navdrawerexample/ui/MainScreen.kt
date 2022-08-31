package com.erapps.navdrawerexample.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.erapps.navdrawerexample.ui.navigation.MainGraph
import com.erapps.navdrawerexample.ui.theme.NavDrawerExampleTheme

@Composable
fun MainScreen() {
    NavDrawerExampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            MainGraph()
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun MainScreenPreview(){
    MainScreen()
}