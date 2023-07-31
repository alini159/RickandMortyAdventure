package com.example.rickandmortyappadventures.presenter.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyappadventures.data.repository.RepositoryImpl
import com.example.rickandmortyappadventures.domain.SearchSource
import com.example.rickandmortyappadventures.domain.model.Personage
import com.example.rickandmortyappadventures.utils.Constants
import kotlinx.coroutines.flow.Flow

class SearchViewModel(private val repository: RepositoryImpl) : ViewModel() {

    fun searchCharacters(query: String): Flow<PagingData<Personage>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.PAGING_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                SearchSource(repository = repository, query)
            }
        ).flow.cachedIn(viewModelScope)
    }
}