package com.example.metrobankassignment.movies.domain.usecases

import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.domain.repositories.MovieDetailsRepository
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow

class MovieDetailsUseCaseImpl(private val repository: MovieDetailsRepository) : MovieDetailsUseCase {
    override suspend fun invoke(id: Int): Flow<Resource<MovieInfo>> {
        return repository.getMovieDetails(id)
    }
}