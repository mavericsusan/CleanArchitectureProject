package com.example.metrobankassignment.movies.domain.usecases


import com.example.metrobankassignment.movies.domain.repositories.MovieRepository
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * use case implementation for movie details
 */
class MoviesListUseCaseImpl(private val repository : MovieRepository) : MoviesListUseCase {
    override suspend fun invoke(): Flow<Resource<List<MovieInfo>>> {
        val repos =  repository.getMarvelMovies()
            return repos

    }
}