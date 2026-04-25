package com.rajesh.cmpcleanarchitecture

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rajesh.cmpcleanarchitecture.presentation.screen.ProductScreen
import com.rajesh.cmpcleanarchitecture.presentation.screen.news.NewsFeedScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        NewsFeedScreen()
    }
}
