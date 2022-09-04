package ru.m0kita.profnotes.model

data class NewNote(
    val avatar: String,
    val name: String,
    val date: String,
    val description: String,
    val usersAvatars: List<String>
)
