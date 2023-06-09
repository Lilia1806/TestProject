package com.example.testproject.data.remote.apiservice

import com.example.testproject.data.dtos.FilmDto
import retrofit2.http.GET

interface FilmApiService {

    @GET("films")
    suspend fun fetchFilm(): List<FilmDto>
}