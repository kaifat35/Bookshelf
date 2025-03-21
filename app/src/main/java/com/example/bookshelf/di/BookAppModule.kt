package com.example.bookshelf.di

import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.data.GoogleBooksApiService
import com.example.bookshelf.data.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBooksRepository(apiService: GoogleBooksApiService): BooksRepository {
        return BooksRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideGoogleBooksApiService(): GoogleBooksApiService {
        return RetrofitInstance.api
    }
}