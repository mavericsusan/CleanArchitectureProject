package com.example.metrobankassignment.movies.data.retrofit

import android.util.Log
import com.example.metrobankassignment.movies.data.dto.MovieInfoDto
import com.example.metrobankassignment.movies.domain.repositories.MovieDetailsRepository
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieDetailsRepositoryImpl(private val apiService: MovieApiService) : MovieDetailsRepository {


    override suspend fun getMovieDetails(id: Int): Flow<Resource<MovieInfo>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response =  apiService.getMovieDetails(id)
                emit(Resource.Success(response.toMovieInfo()))
            }catch (e:Exception){
                emit(Resource.Error(null, e.message.toString()))
            }


        }.flowOn(Dispatchers.Main) as Flow<Resource<MovieInfo>>
    }

}