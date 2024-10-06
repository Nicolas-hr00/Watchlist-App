package com.example.watchlistaplication.presentation.company_listings
//helps to call our data layer functions and taking this data from the repository and map the data to the UI

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.watchlistaplication.domain.repository.StockRepository
import com.example.watchlistaplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
 class CompanyListingsViewModel @Inject constructor(
    private val repository: StockRepository
): ViewModel(){

    var state by mutableStateOf(CompanyListingsState())
    private var searchJob: Job? =null

    fun onEvent(event: CompanyListingsEvent) {
        when(event) {
            is CompanyListingsEvent.Refresh -> {
                getCompanyListings(fetchFromRemote = true)
            }
            is CompanyListingsEvent.OnSearchQueryChange -> {
                state = state.copy (searchQuery = event.query)
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    getCompanyListings()
                }
            }
        }
    }

   private fun getCompanyListings(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false
    )   {
        viewModelScope.launch {
            repository
                .getCompanyListings(fetchFromRemote,query)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                state = state.copy (
                                    companies = listings
                                )
                            }
                        }
                        is Resource.Error -> Unit

                        is Resource.Loading -> {
                            state = state.copy (isLoading = result.isLoading)
                        }

                        else -> {}
                    }
                }
        }
    }
}