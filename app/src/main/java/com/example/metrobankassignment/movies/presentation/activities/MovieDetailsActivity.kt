package com.example.metrobankassignment.movies.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.databinding.DataBindingUtil
import com.example.metrobankassignment.R
import com.example.metrobankassignment.databinding.ActivityMovieDetailsBinding
import com.example.metrobankassignment.movies.MoviesApplication
import com.example.metrobankassignment.movies.domain.models.MovieInfo


import com.example.metrobankassignment.movies.presentation.viewmodels.MovieDetailsViewModel

import javax.inject.Inject


/**
 * @MovieDetailsActivity class responsible for a movie details
 */
class MovieDetailsActivity : AppCompatActivity() {
    /*
      Dagger provides the viewmodel instance
     */
    @Inject
    lateinit var viewModel: MovieDetailsViewModel
    lateinit var binding : ActivityMovieDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        /**
         *activity is injected with dependencies..
         */
        MoviesApplication.daggerMoviesComponent.inject(this)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val id = intent?.getIntExtra("id",1)
        subscribeforMovieDetail()
        viewModel.getMovieDetails(id!!)
    }

    /**
     * observe the changes in live data of @MovieDetailsViewModel for movie details.
     */
    private fun subscribeforMovieDetail() {
       viewModel.dataState.observe(this,  {it ->

       })
    }




}