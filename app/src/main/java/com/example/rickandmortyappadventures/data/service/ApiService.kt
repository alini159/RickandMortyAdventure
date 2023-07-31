package com.example.rickandmortyappadventures.data.service

import com.example.rickandmortyappadventures.utils.Constants.Companion.END_POINT
import com.example.rickandmortyappadventures.domain.model.PersonageList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(END_POINT)
    suspend fun getCharacters(@Query("page")page:Int): Response<PersonageList>
    @GET(END_POINT)
    suspend fun searchCharacters(@Query("page")page:Int, @Query("name") name: String): Response<PersonageList>
}