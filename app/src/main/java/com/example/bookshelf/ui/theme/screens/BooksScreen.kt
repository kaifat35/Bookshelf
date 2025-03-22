package com.example.bookshelf.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.Alignment


@Composable
fun BooksScreen(viewModel: BooksViewModel) {
    val books by viewModel.books.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(books.size) { index ->
            val book = books[index]
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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.75f)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.66f) // Соотношение сторон изображения (например, 2:3)
        )
        Text(
            text = book.volumeInfo.title,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}