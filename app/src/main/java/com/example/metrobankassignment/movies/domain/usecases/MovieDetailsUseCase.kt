package com.example.metrobankassignment.movies.domain.usecases

import com.example.metrobankassignment.movies.domain.repositories.MovieDetailsRepository
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

interface MovieDetailsUseCase  {
     suspend operator fun invoke(id:Int): Flow<Resource<MovieInfo>>


}
