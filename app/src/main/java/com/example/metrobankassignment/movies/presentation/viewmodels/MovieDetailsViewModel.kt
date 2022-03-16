package com.example.metrobankassignment.movies.presentation.viewmodels

import androidx.lifecycle.*
import com.example.metrobankassignment.movies.domain.models.MovieInfo

import com.example.metrobankassignment.movies.domain.usecases.MovieDetailsUseCase
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


import javax.inject.Inject

/**
 * @MovieDetailsViewModel handle logic for details of movie
 */

class MovieDetailsViewModel @Inject constructor(private val useCase: MovieDetailsUseCase) :
    ViewModel() {
    private val _errorState: MutableLiveData<String> = MutableLiveData()
    val errorState: LiveData<String>
        get() = _errorState
    private val _movieDetails: MutableLiveData<MovieInfo?> = MutableLiveData()
    val movieDetails: MutableLiveData<MovieInfo?>
    get() = _movieDetails
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    fun getMovieDetails(id: Int) {
            getMovieDetailsFlow(id)
    }

    /**
     * viewmodel communicates with use case for the data..
     * observe the api call as flow and set the
     * response as datastate live data
     */
    fun getMovieDetailsFlow(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            useCase(id).collect {
            when(it){
                is Resource.Success -> {
                    _isLoading.value = false
                    _movieDetails.value = it.data
                }
                is Resource.Loading ->{
                    _isLoading.value = true
                }
                is Resource.Error -> {
                    _isLoading.value = false
                    _errorState.value = it.message.toString()
                }
            }
            }
        }
    }


}