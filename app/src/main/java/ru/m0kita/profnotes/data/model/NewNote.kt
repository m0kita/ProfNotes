package ru.m0kita.profnotes.data.model

data class NewNote(
    val avatar: String,
    val name: String,
    val date: String,
    val description: String,
    val usersAvatars: List<String>
)
