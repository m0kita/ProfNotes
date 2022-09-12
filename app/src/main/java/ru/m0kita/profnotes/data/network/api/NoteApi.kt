package ru.m0kita.profnotes.data.network.api

import retrofit2.Response
import retrofit2.http.GET
import ru.m0kita.profnotes.data.model.Note
import ru.m0kita.profnotes.data.model.NoteResponse

interface NoteApi {
    @GET("notes")
    fun getNotes(): NoteResponse

    @GET("todo3")
    suspend fun getNote(): Response<Note>
}