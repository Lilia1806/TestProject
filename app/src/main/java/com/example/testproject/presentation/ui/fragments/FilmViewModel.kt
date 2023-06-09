package com.example.testproject.presentation.ui.fragments

import androidx.lifecycle.ViewModel
import com.example.testproject.domain.usecases.FilmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmViewModel@Inject constructor(
    private val filmUseCase: FilmUseCase
) : ViewModel() {

    suspend fun fetchFilm() = filmUseCase.invoke()
}