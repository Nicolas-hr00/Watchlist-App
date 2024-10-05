package com.example.watchlistaplication.util
//if we have a success, we attach a value. Otherwise we attach an error message
sealed class Resource <T> (val data: T? = null, val message: String? = null)