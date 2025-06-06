package com.example.donutapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DonutViewModel : ViewModel() {
    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {

        }
    }

    fun onIncreaseCounter() {
        _state.update { it + 1 }
    }

    fun onDecreaseCounter() {
        if (_state.value <= 0) {
            return
        }
        _state.update { it - 1 }
    }

}