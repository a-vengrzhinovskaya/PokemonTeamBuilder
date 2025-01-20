package com.example.pokemonteambuilder.ui.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class StateViewModel<T>(initialSate: T) : ViewModel() {
    protected val _state = MutableStateFlow(initialSate)
    val state: StateFlow<T> = _state.asStateFlow()
}