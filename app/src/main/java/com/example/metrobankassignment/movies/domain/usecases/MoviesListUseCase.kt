package com.example.metrobankassignment.movies.domain.usecases

import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesListUseCase {
    suspend operator fun invoke() : Flow<Resource<List<MovieInfo>>>
}