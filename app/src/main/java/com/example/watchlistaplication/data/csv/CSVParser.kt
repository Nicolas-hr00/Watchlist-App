package com.example.watchlistaplication.data.csv

import java.io.InputStream

interface CSVParser <T> {
    suspend fun parse (stream: InputStream): List<T>
}