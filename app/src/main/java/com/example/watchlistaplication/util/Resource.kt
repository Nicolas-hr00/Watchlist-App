package com.example.watchlistaplication.util

import com.example.watchlistaplication.domain.model.CompanyListing

//if we have a success, we attach a value. Otherwise we attach an error message
sealed class Resource <T> (val data: T? = null, val message: String? = null) {
    class Success <T>(data:T?): Resource <T> (data)
    class Error <T>(message: String, data: T? = null): Resource <T> (data, message)
    class Loading<T> (val isLoading: Boolean = true): Resource<T>(null)//we don't have data here
    class Success(data: List<CompanyListing>) : Resource<List<CompanyListing>>() {

    }
}