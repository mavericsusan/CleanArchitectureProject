package com.example.metrobankassignment.movies.domain.repositories

import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getMarvelMovies() : Flow<Resource<List<MovieInfo>>>

}