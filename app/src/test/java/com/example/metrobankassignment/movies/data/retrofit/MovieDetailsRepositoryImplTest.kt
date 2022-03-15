package com.example.metrobankassignment.movies.data.retrofit

import com.example.metrobankassignment.movies.data.dto.MovieInfoDto
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.domain.usecases.MovieDetailsUseCase
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
import org.mockito.exceptions.base.MockitoException
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class MovieDetailsRepositoryImplTest{
    private lateinit var useCase : MovieDetailsUseCase
    private lateinit var repository: MovieDetailsRepositoryImpl
    private lateinit var apiService : MovieApiService
    private lateinit var movieResponse : MovieInfoDto
    private lateinit var movieInfoResponse : MovieInfo
    val dispacher = TestCoroutineDispatcher()
    @Before
    fun setUp(){
        Dispatchers.setMain(dispacher)
        apiService = mock<MovieApiService>()
        movieResponse = mock<MovieInfoDto>()
        movieInfoResponse = mock<MovieInfo>()
        repository = MovieDetailsRepositoryImpl(apiService)
        useCase = MovieDetailsUseCase(repository)
    }
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }
    @Test
    fun testGetMovieDetails()= runBlocking {
        Mockito.`when`(apiService.getMovieDetails(1)).thenReturn(movieResponse)
        val loadingState = repository.getMovieDetails(1).first()
        val apiResponse = repository.getMovieDetails(1).drop(1).first()
        TestCase.assertTrue(loadingState is Resource.Loading)
        TestCase.assertTrue(apiResponse is Resource.Success)
    }

    @Test
    fun testGetErrorMovieDetails() = runBlocking {
        Mockito.`when`(apiService.getMovieDetails(1)).thenThrow(MockitoException("SomeError"))
        val loadingState = repository.getMovieDetails(1).first()
        val apiResponse = repository.getMovieDetails(1).drop(1).first()
        TestCase.assertTrue(loadingState is Resource.Loading)
        TestCase.assertTrue(apiResponse is Resource.Error)
    }

    @Test
    fun testLoadingMovies() = runBlocking {
        Mockito.`when`(apiService.getMovieDetails(1)).thenReturn(movieResponse)
        val loadingState = repository.getMovieDetails(1).first()
        TestCase.assertTrue(loadingState is Resource.Loading)
    }
}