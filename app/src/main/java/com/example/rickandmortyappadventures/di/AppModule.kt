package com.example.rickandmortyappadventures.di

import com.example.rickandmortyappadventures.data.repository.RepositoryImpl
import com.example.rickandmortyappadventures.data.service.ApiService
import com.example.rickandmortyappadventures.utils.Constants.Companion.BASE_URL
import com.example.rickandmortyappadventures.presenter.viewModel.HomeViewModel
import com.example.rickandmortyappadventures.presenter.viewModel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val AppModule = module {

    single<RepositoryImpl> { RepositoryImpl(get()) }
    viewModel<HomeViewModel> { HomeViewModel(get()) }
    viewModel<SearchViewModel> { SearchViewModel(get()) }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(ApiService::class.java) }
}



