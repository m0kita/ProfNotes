package ru.m0kita.profnotes.data.model

data class MyNote(
    val id: Int,
    val title: String,
    val date: String,
    val status: Status,
    val description: String
)