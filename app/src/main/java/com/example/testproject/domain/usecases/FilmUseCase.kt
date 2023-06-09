package com.example.testproject.domain.usecases

import com.example.testproject.domain.repositories.FilmRepository
import javax.inject.Inject

class FilmUseCase @Inject constructor(
    private val filmRepository: FilmRepository
) {

    suspend operator fun invoke() = filmRepository.fetchFilm()
}