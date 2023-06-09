package com.example.testproject.data.dtos

import com.example.testproject.domain.models.Film
import com.google.gson.annotations.SerializedName

data class FilmDto(
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("director")
    val director: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("vehicles")
    val vehicles: List<String>?,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("rt_score")
    val rtScore: String = "",
    @SerializedName("people")
    val people: List<String>?,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("species")
    val species: List<String>?,
    @SerializedName("original_title_romanised")
    val originalTitleRomanised: String = "",
    @SerializedName("producer")
    val producer: String = "",
    @SerializedName("running_time")
    val runningTime: String = "",
    @SerializedName("locations")
    val locations: List<String>?,
    @SerializedName("id")
    val id: String = ""
)

fun FilmDto.toDomain(): Film {
    return Film(
        originalTitle,
        director,
        description,
        vehicles,
        title,
        rtScore,
        people,
        url,
        releaseDate,
        species,
        originalTitleRomanised,
        producer,
        runningTime,
        locations,
        id
    )
}
