package com.example.bookshelf.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.data.BookItem
import com.example.bookshelf.viewmodel.BooksViewModel
import androidx.compose.runtime.getValue

@Composable
fun BooksScreen(viewModel: BooksViewModel) {
    val books by viewModel.books.collectAsState()

    LazyColumn {
        items(books) { book ->
            BookItem(book)
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadBooks("android", 10)
    }
}

@Composable
fun BookItem(book: BookItem) {
    val imageUrl = book.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://")

    Column {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Text(text = book.volumeInfo.title)
    }
}