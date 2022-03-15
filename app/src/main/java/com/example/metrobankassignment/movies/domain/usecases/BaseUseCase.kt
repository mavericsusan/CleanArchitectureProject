package com.example.metrobankassignment.movies.domain.usecases

import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow

interface BaseUseCase<T> {
    operator suspend fun invoke() : T
}