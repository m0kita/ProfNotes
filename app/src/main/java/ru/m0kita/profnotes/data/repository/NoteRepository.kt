package ru.m0kita.profnotes.data.repository

import ru.m0kita.profnotes.data.model.Note
import ru.m0kita.profnotes.data.model.util.ResponseWrapper
import ru.m0kita.profnotes.data.network.api.NoteApi
import ru.m0kita.profnotes.data.repository.core.BaseRepository
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteApi: NoteApi,
) : BaseRepository() {
    suspend fun getNote(): ResponseWrapper<Note> =
        getResponseInResponseWrapper(noteApi.getNote())
}