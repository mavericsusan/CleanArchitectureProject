package com.example.metrobankassignment.movies.data.retrofit


import com.example.metrobankassignment.movies.domain.repositories.MovieRepository
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * implementation class for movie list repository
 */
class MovieListRepositoryImpl (private val apiService : MovieApiService) : MovieRepository {
      override suspend fun getMarvelMovies(): Flow<Resource<List<MovieInfo>>> {
          return flow {
              emit(Resource.Loading())
              try{
                  val list = apiService.getMovieList()
                  emit(Resource.Success(list.data.map {
                      it.toMovieInfo()
                  }))
              }catch (e:Exception){
                  emit(Resource.Error(null,e.message.toString()))
              }

          }.flowOn(Dispatchers.Main) as Flow<Resource<List<MovieInfo>>>
      }
    }
