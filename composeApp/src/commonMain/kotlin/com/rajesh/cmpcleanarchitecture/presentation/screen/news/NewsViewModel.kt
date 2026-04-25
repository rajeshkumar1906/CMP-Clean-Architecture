package com.rajesh.cmpcleanarchitecture.presentation.screen.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rajesh.cmpcleanarchitecture.domain.usecase.GetProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(
    private val useCase: GetProductsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(NewsDetailsContract.State())
    val state: StateFlow<NewsDetailsContract.State> = _state

    fun process(intent: NewsDetailsContract.Intent) {
        when (intent) {
            is NewsDetailsContract.Intent.LoadNews -> getNews()
        }
    }

    private fun getNews() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try{
                val news = useCase.invoke()
                news.collectLatest {
                    _state.update { it.copy(news = it.news, isLoading = false) }
                }
            }catch (e: Exception){
                _state.update { it.copy(isLoading = false) }
            }
        }

    }

}