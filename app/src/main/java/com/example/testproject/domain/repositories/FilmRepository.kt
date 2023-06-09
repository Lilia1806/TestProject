package com.example.testproject.domain.repositories

import com.bumptech.glide.load.engine.Resource
import com.example.testproject.domain.models.Film
import kotlinx.coroutines.flow.Flow

interface FilmRepository {

    fun fetchFilm(): Flow<com.example.testproject.utils.Resource<List<Film>>>
}