package com.example.metrobankassignment.movies.data.di.module

import com.example.metrobankassignment.movies.data.retrofit.MovieApiService
import com.example.metrobankassignment.movies.data.retrofit.MovieDetailsRepositoryImpl
import com.example.metrobankassignment.movies.data.retrofit.MovieListRepositoryImpl
import com.example.metrobankassignment.movies.domain.repositories.MovieDetailsRepository
import com.example.metrobankassignment.movies.domain.repositories.MovieRepository
import com.example.metrobankassignment.movies.domain.usecases.MovieDetailsUseCase
import com.example.metrobankassignment.movies.domain.usecases.MoviesListUseCase
import com.example.metrobankassignment.movies.util.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**@Module informs Dagger that this class is a Dagger Module
 * Dagger module class for api repository and usecases
 */
@Module
class MoviesModule {

    /**
     * Returns a use case for fetching the movies list
     */
    @Provides
    fun getMoviesListUseCase(repository: MovieRepository) : MoviesListUseCase{
        return MoviesListUseCase(repository)
    }
    /**
     * Returns a use case for fetching the movies details
     */
    @Provides
    fun getMoviesDetailsUseCase(repository: MovieDetailsRepository) : MovieDetailsUseCase{
        return MovieDetailsUseCase(repository)
    }

    @Provides
    fun getMovieDetailsRepository(apiService: MovieApiService) :MovieDetailsRepository{
        return MovieDetailsRepositoryImpl(apiService)
    }

    @Provides
    fun getMovieListRepository(apiService: MovieApiService) : MovieRepository {
        return MovieListRepositoryImpl(apiService)
    }

}