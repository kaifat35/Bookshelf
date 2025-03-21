package com.example.bookshelf.data

import com.google.gson.annotations.SerializedName

data class BooksResponse(
    @SerializedName("items") val items: List<BookItem>
)

data class BookItem(
    @SerializedName("volumeInfo") val volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @SerializedName("title") val title: String,
    @SerializedName("imageLinks") val imageLinks: ImageLinks?
)

data class ImageLinks(
    @SerializedName("thumbnail") val thumbnail: String
)