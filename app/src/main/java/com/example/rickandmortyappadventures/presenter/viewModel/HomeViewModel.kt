package com.example.rickandmortyappadventures.presenter.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyappadventures.data.repository.RepositoryImpl
import com.example.rickandmortyappadventures.domain.HomeSource
import com.example.rickandmortyappadventures.domain.model.Personage
import com.example.rickandmortyappadventures.utils.Constants.Companion.PAGING_SIZE
import kotlinx.coroutines.flow.Flow

class HomeViewModel(val repository: RepositoryImpl) : ViewModel() {
    fun getCharacters(): Flow<PagingData<Personage>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGING_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                HomeSource(repository = repository)
            }
        ).flow.cachedIn(viewModelScope)
    }
}