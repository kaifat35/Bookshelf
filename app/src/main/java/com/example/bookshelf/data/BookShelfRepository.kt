package com.example.bookshelf.data

class BooksRepository(private val apiService: GoogleBooksApiService) {

    suspend fun getBooks(query: String, maxResults: Int): List<BookItem> {
        return apiService.searchBooks(query, maxResults).items
    }
}