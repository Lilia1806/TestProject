package com.example.testproject.data.repositories

import com.example.testproject.data.dtos.toDomain
import com.example.testproject.data.remote.apiservice.FilmApiService
import com.example.testproject.domain.base.BaseRepository
import com.example.testproject.domain.repositories.FilmRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmRepositoryImpl @Inject constructor(private val filmApiService: FilmApiService) :
    BaseRepository(), FilmRepository {

    override fun fetchFilm() = doRequest {
        filmApiService.fetchFilm().map {
            it.toDomain()
        }
    }

}