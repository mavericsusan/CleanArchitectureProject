package com.example.metrobankassignment.movies.data.di.component

import com.example.metrobankassignment.movies.data.di.module.MoviesModule
import com.example.metrobankassignment.movies.data.di.module.NetworkModule
import com.example.metrobankassignment.movies.presentation.activities.MovieDetailsActivity
import com.example.metrobankassignment.movies.presentation.activities.MovieListActivity

import dagger.Component

import javax.inject.Singleton

/**
 * The "modules" attribute in the @Component annotation tells Dagger
 * what Modules to include.
 * @Singleton is used to annorate the scope
 */

@Singleton
@Component(modules = [MoviesModule::class, NetworkModule::class])

interface MoviesComponent {

    fun inject(listActivity: MovieListActivity)
    fun inject(detailsActivity: MovieDetailsActivity)

}