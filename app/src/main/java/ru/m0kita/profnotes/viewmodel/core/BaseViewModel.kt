package ru.m0kita.profnotes.viewmodel.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _eventState = MutableStateFlow<Event>(Event.Idle)
    val eventState = _eventState.asStateFlow()

    @Suppress("unused")
    protected fun setIsLoading(value: Boolean) {
        _isLoading.value = value
    }

    protected fun launchSafety(
        errHandler: ((Throwable) -> Unit)? = null,
        block: suspend CoroutineScope.() -> Unit,
    ) {
        _isLoading.value = true
        val errorHandler = CoroutineExceptionHandler { _, throwable ->
            errHandler?.invoke(throwable) ?: errHandler.apply {
                _eventState.value = Event.Toast(throwable.message.toString())
                _eventState.value = Event.Idle
            }
        }
        (viewModelScope + errorHandler).launch(Dispatchers.IO) {
            block()
        }.invokeOnCompletion { _isLoading.value = false }
    }
}