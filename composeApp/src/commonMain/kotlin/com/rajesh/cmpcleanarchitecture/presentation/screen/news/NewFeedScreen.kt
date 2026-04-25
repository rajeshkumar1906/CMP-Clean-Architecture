package com.rajesh.cmpcleanarchitecture.presentation.screen.news

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NewsFeedScreen(
    newsFeedViewModel: NewsViewModel = koinViewModel()
){
    val state by newsFeedViewModel.state.collectAsState()

    LaunchedEffect(Unit){
        newsFeedViewModel.process(NewsDetailsContract.Intent.LoadNews)
    }

    when {
        state.isLoading -> Text("Loading...")
        state.news.isNotEmpty() -> LazyColumn {
            items(state.news.size) { news ->
                Text(state.news[news].title)
            }
        }
        else -> Text("Error: ${state.error}")
    }

}