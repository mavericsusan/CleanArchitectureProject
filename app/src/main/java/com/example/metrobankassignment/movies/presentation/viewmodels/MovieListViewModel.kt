package com.example.metrobankassignment.movies.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.domain.usecases.MoviesListUseCase
import com.example.metrobankassignment.movies.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * viewModel class for the fetching the list of movies..
 */
class MovieListViewModel @Inject constructor(private val useCase : MoviesListUseCase) :
    ViewModel() {
    private val _dataState: MutableLiveData<List<MovieInfo>> = MutableLiveData()
    val dataState: MutableLiveData<List<MovieInfo>>
        get() = _dataState
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _errorMsg: MutableLiveData<String> = MutableLiveData()
    val errorMsg: LiveData<String>
        get() = _errorMsg

    init {
        getMovieList()
    }

    /**
     *viewmodel communicates with use case for the data..
     * observe the api call as flow and set the
     * response as datastate live data
     */
    fun getMovieList() {
        viewModelScope.launch(Dispatchers.Main) {
            useCase().collect {movieList ->
                when(movieList){
                    is Resource.Loading -> {
                     _isLoading.value = true
                    }
                    is Resource.Success -> {
                        _isLoading.value = false
                        _dataState.value = movieList.data!!
                    }
                    is Resource.Error -> {
                        _isLoading.value = false
                        _errorMsg.value = movieList.message!!

                    }
                }
            }
        }

    }
}