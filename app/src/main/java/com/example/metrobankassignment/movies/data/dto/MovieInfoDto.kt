package com.example.metrobankassignment.movies.data.dto

import com.example.metrobankassignment.movies.domain.models.MovieInfo

/**
 * server model class for movie
 */
data class MovieInfoDto(
    val box_office: String,
    val chronology: Int,
    val duration: Int,
    val cover_url: String,
    val directed_by: String,
    val id: Int,
    val imdb_id: String,
    val overview: String,
    val phase: Int,
    val post_credit_scenes: Int,
    val related_movies: List<RelatedMovy>,
    val release_date: String,
    val saga: String,
    val title: String,
    val trailer_url: String
) {
    fun toMovieInfo(): MovieInfo {
        return MovieInfo(
            box_office = box_office,
            chronology = chronology,
            cover_url = cover_url,
            directed_by = directed_by,
            id = id,
            imdb_id = imdb_id,
            overview = overview,
            phase = phase,
            release_date = release_date,
            saga = saga,
            title = title
        )
    }
}