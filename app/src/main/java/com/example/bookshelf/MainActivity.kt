package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bookshelf.ui.theme.BookshelfTheme
import com.example.bookshelf.ui.theme.screens.BooksScreen
import com.example.bookshelf.viewmodel.BooksViewModel
import dagger.hilt.android.AndroidEntryPoint

/*Это приложение для Android, которое использует Jetpack Compose
для создания пользовательского интерфейса и Hilt для внедрения зависимостей.
Оно позволяет пользователю искать книги через Google Books API и отображает результаты в виде списка
Приложение запускается с BookshelfApplication, который инициализирует Hilt.
MainActivity устанавливает содержимое экрана и создает BooksViewModel с помощью Hilt.
BooksScreen отображает список книг, используя данные из BooksViewModel.
BooksViewModel взаимодействует с BooksRepository, чтобы получить данные из API.
BooksRepository использует GoogleBooksApiService для выполнения запросов к API.
Данные, возвращаемые API, преобразуются в объекты Kotlin с помощью Retrofit и Gson.
Результаты отображаются на экране с помощью Jetpack Compose. */

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