package com.example.rickandmortyappadventures.domain

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyappadventures.data.repository.RepositoryImpl
import com.example.rickandmortyappadventures.domain.model.Personage
import com.example.rickandmortyappadventures.utils.Constants.Companion.START_PAGING
import com.example.rickandmortyappadventures.utils.ExceptionModel
import com.example.rickandmortyappadventures.utils.NetworkResult

class SearchSource(private val repository: RepositoryImpl, private val query: String) :
    PagingSource<Int, Personage>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Personage> {
        try {
            return when (val response = repository.searchCharacters(params.key ?: START_PAGING, query)) {
                is NetworkResult.Success -> {
                    LoadResult.Page(
                        data = response.data.results,
                        prevKey = params.key,
                        nextKey = if (response.data.results.isEmpty()) {
                            null
                        } else {
                            params.key?.plus(1) ?: START_PAGING.plus(1)
                        }
                    )
                }

                is NetworkResult.Error -> {
                    LoadResult.Error(ExceptionModel())
                }
            }

        } catch (e: Throwable) {
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Personage>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}