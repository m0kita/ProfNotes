package ru.m0kita.profnotes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.m0kita.profnotes.data.model.Note
import ru.m0kita.profnotes.data.model.util.ResponseWrapper
import ru.m0kita.profnotes.data.repository.NoteRepository
import ru.m0kita.profnotes.viewmodel.core.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : BaseViewModel() {

    private var _note = MutableStateFlow<ResponseWrapper<Note>>(ResponseWrapper.Idle())
    val note = _note.asStateFlow()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getNote() {
        launchSafety(
            errHandler = {
                if (it is NullPointerException) Log.e("lol", "lol")
            }
        ) {
            _note.value = noteRepository.getNote()
        }
    }
}