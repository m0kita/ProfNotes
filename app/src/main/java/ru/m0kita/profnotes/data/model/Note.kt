package ru.m0kita.profnotes.data.model

data class Note(
    val name: String,
    val description: String = "",
    val time: String = "",
    val status: Status
)