package com.example.metrobankassignment.movies.data.dto
/**
 * server model class for movie list
 */
data class MovieListDto(
    val `data`: List<MovieInfoDto>,
    val total: Int
)