package com.example.metrobankassignment.movies.data.di.module

import com.example.metrobankassignment.movies.data.remote.MovieApiService
import com.example.metrobankassignment.movies.data.repository.MovieDetailsRepositoryImpl
import com.example.metrobankassignment.movies.data.repository.MovieListRepositoryImpl
import com.example.metrobankassignment.movies.domain.repositories.MovieDetailsRepository
import com.example.metrobankassignment.movies.domain.repositories.MovieRepository
import com.example.metrobankassignment.movies.domain.usecases.MovieDetailsUseCase
import com.example.metrobankassignment.movies.domain.usecases.MovieDetailsUseCaseImpl
import com.example.metrobankassignment.movies.domain.usecases.MoviesListUseCase
import com.example.metrobankassignment.movies.domain.usecases.MoviesListUseCaseImpl
import dagger.Module
import dagger.Provides

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
        return MoviesListUseCaseImpl(repository)
    }
    /**
     * Returns a use case for fetching the movies details
     */
    @Provides
    fun getMoviesDetailsUseCase(repository: MovieDetailsRepository) : MovieDetailsUseCase{
        return MovieDetailsUseCaseImpl(repository)
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