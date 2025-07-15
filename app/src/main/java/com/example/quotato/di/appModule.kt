package com.example.quotato.di

import com.example.quotato.data.network.QuoteApiService
import com.example.quotato.data.network.RetrofitClient
import com.example.quotato.data.repository.QuoteRepository
import com.example.quotato.ui.viewmodel.QuoteViewModel
import org.koin.dsl.module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf

val appModule = module {
    singleOf(::RetrofitClient)
    single { get<RetrofitClient>().createService(QuoteApiService::class.java) }
    factoryOf(::QuoteRepository)
    viewModelOf(::QuoteViewModel)
}
