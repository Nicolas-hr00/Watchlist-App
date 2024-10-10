package com.example.watchlistaplication.di

import com.example.watchlistaplication.data.csv.CSVParser
import com.example.watchlistaplication.data.csv.CompanyListingsParser
import com.example.watchlistaplication.data.repository.StockRepostoryImpl
import com.example.watchlistaplication.domain.model.CompanyListing
import com.example.watchlistaplication.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser (
        companyListingsParser: CompanyListingsParser
    ): CSVParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository (
        stockRepostoryImpl: StockRepostoryImpl
    ): StockRepository
}