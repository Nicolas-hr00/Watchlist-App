package com.example.watchlistaplication.presentation.company_listings

import com.example.watchlistaplication.domain.model.CompanyListing

//everything is relevant for the UI
data class CompanyListingsState(
    val companies: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
