package com.example.testproject.di

import com.example.testproject.data.repositories.FilmRepositoryImpl
import com.example.testproject.domain.repositories.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun provideFilmRepository(repositoryImpl: FilmRepositoryImpl): FilmRepository
}