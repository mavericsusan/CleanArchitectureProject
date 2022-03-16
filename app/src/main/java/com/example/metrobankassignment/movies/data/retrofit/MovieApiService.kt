package com.example.metrobankassignment.movies.data.retrofit

import com.example.metrobankassignment.movies.data.dto.MovieInfoDto
import com.example.metrobankassignment.movies.data.dto.MovieListDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * api service class
 */
interface MovieApiService {

    @GET("/api/v1/movies?page=1&limit=10")
    suspend fun getMovieList() : MovieListDto

    @GET("/api/v1/movies/{id}")
    suspend fun getMovieDetails(@Path("id")id:Int) : MovieInfoDto
}