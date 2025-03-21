package com.example.bookshelf.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookshelf.data.BookItem
import com.example.bookshelf.data.BooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BooksViewModel @Inject constructor(
    private val repository: BooksRepository
) : ViewModel() {

    private val _books = MutableStateFlow<List<BookItem>>(emptyList())
    val books: StateFlow<List<BookItem>> get() = _books

    fun loadBooks(query: String, maxResults: Int) {
        viewModelScope.launch {
            _books.value = repository.getBooks(query, maxResults)
        }
    }
}