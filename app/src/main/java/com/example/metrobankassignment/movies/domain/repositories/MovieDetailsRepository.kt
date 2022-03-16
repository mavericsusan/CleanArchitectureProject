package com.example.metrobankassignment.movies.domain.repositories

import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * interface for movie details repository
 */
interface MovieDetailsRepository {
    suspend fun getMovieDetails(id: Int): Flow<Resource<MovieInfo>>
}