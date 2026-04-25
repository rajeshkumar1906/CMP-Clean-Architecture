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
                val newsResult = useCase.invoke()
                newsResult.collectLatest { result ->
                    when (result) {
                        is com.rajesh.cmpcleanarchitecture.domain.handlers.Result.Success -> {
                            _state.update { it.copy(news = result.data, isLoading = false) }
                        }
                        is com.rajesh.cmpcleanarchitecture.domain.handlers.Result.Error -> {
                            _state.update { it.copy(error = result.error.toString(), isLoading = false) }
                        }
                    }
                }
            }catch (e: Exception){
                _state.update { it.copy(isLoading = false, error = e.toString()) }
            }
        }

    }

}