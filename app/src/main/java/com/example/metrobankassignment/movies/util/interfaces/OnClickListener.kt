package com.example.metrobankassignment.movies.util.interfaces

import com.example.metrobankassignment.movies.domain.models.MovieInfo

interface OnClickListener {
    fun onItemClickListener(movieInfo: MovieInfo)
}