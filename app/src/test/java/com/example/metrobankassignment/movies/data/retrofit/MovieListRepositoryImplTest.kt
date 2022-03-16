package com.example.metrobankassignment.movies.data.retrofit

import com.example.metrobankassignment.movies.data.dto.MovieListDto
import com.example.metrobankassignment.movies.domain.usecases.MoviesListUseCase
import com.example.metrobankassignment.movies.domain.usecases.MoviesListUseCaseImpl
import com.example.metrobankassignment.movies.util.Resource
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class MovieListRepositoryImplTest{
    private lateinit var useCase : MoviesListUseCase
    private lateinit var repository: MovieListRepositoryImpl
    private lateinit var apiService : MovieApiService
    private lateinit var movieResponse : MovieListDto
    val dispacher = TestCoroutineDispatcher()
    @Before
    fun init(){
        Dispatchers.setMain(dispacher)
        apiService = mock<MovieApiService>()
        movieResponse = mock<MovieListDto>()
        repository = MovieListRepositoryImpl(apiService)
        useCase = MoviesListUseCaseImpl(repository)
    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testGetMovies()= runBlocking {
        Mockito.`when`(apiService.getMovieList()).thenReturn(movieResponse)
        val apiResponse = repository.getMarvelMovies().drop(1).first()
        TestCase.assertTrue(apiResponse is Resource.Success)
    }

    @Test
    fun testGetEmptyMovies()= runBlocking {
        Mockito.`when`(apiService.getMovieList()).thenThrow(ArrayIndexOutOfBoundsException("Error"))
        val apiResponse = repository.getMarvelMovies().drop(1).first()
        TestCase.assertTrue(apiResponse is Resource.Error)
    }
    @Test
    fun testLoadingMovies() = runBlocking {
        Mockito.`when`(apiService.getMovieList()).thenReturn(movieResponse)
        val loadingState = repository.getMarvelMovies().first()
        TestCase.assertTrue(loadingState is Resource.Loading)
    }
}