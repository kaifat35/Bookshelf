package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bookshelf.ui.theme.BookshelfTheme
import com.example.bookshelf.ui.theme.screens.BooksScreen
import com.example.bookshelf.viewmodel.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookshelfTheme {
                val viewModel: BooksViewModel = hiltViewModel()
                BooksScreen(viewModel)
            }
        }
    }
}