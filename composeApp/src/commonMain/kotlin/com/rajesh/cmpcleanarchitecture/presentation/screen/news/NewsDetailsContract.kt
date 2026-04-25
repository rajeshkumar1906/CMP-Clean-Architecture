package com.rajesh.cmpcleanarchitecture.presentation.screen.news

import com.rajesh.cmpcleanarchitecture.domain.model.NewsData

object NewsDetailsContract {
    sealed class Intent{
        object LoadNews : Intent()
    }

    data class State(
        val isLoading: Boolean = false,
        val news: List<NewsData> =emptyList(),
        val error: String = "")
    sealed class Effect {
        data class ShowError(val message: String) : Effect()
    }
}