package com.example.watchlistaplication.domain.repository

import com.example.watchlistaplication.domain.model.CompanyListing
import com.example.watchlistaplication.util.Resource
import kotlinx.coroutines.flow.Flow

interface StockRepository {

    suspend fun getCompanyListings(
     fetchFromRemote: Boolean,
     query:String
    ): Flow<Resource<List<CompanyListing>>>
}