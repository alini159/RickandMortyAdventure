package com.example.rickandmortyappadventures.data.repository

import com.example.rickandmortyappadventures.data.ApiResponse
import com.example.rickandmortyappadventures.domain.model.PersonageList
import com.example.rickandmortyappadventures.data.service.ApiService
import com.example.rickandmortyappadventures.utils.NetworkResult

class RepositoryImpl(private val apiService: ApiService) : ApiResponse() {
     suspend fun getCharacters(page: Int): NetworkResult<PersonageList> {
        return safeApiCall {  apiService.getCharacters(page = page) }
    }

    suspend fun searchCharacters(page: Int, query: String): NetworkResult<PersonageList> {
        return safeApiCall {  apiService.searchCharacters(page = page, query) }
    }
}