package ru.m0kita.profnotes.model

data class Note(
    val name: String,
    val description: String = "",
    val time: String = "",
    val status: Status
)