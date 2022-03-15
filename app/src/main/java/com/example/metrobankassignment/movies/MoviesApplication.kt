package com.example.metrobankassignment.movies

import android.app.Application
import com.example.metrobankassignment.movies.data.di.component.DaggerMoviesComponent
import com.example.metrobankassignment.movies.data.di.component.MoviesComponent
import com.example.metrobankassignment.movies.data.di.module.MoviesModule


class MoviesApplication : Application(){
    /**
     * this component is used across the application.
     */

    override fun onCreate() {
        super.onCreate()
         daggerMoviesComponent = DaggerMoviesComponent.create()
    }
    companion object {
        lateinit var daggerMoviesComponent : MoviesComponent
    }

}
