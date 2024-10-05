package com.example.watchlistaplication.data.mapper

import com.example.watchlistaplication.data.local.CompanyListingEntity
import com.example.watchlistaplication.domain.model.CompanyListing

fun CompanyListingEntity.toCompanyListing(): CompanyListing{

    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange,
    )
}
//this is to map thse 2
fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity{

    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange,
    )
}