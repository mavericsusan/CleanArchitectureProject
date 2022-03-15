package com.example.metrobankassignment.movies.presentation.activities


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.metrobankassignment.R
import com.example.metrobankassignment.databinding.ActivityMovieListBinding
import com.example.metrobankassignment.movies.MoviesApplication
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.presentation.viewmodels.MovieListViewModel
import com.example.metrobankassignment.movies.util.interfaces.onClickListener
import com.example.movieapp.presentation.adapters.MovieListAdapter
import javax.inject.Inject

/**
 * activity to display the list of movies..
 */

class MovieListActivity : AppCompatActivity(), onClickListener{
    /*
    Dagger provides the viewmodel instance
     */
    @Inject
     lateinit var viewModel : MovieListViewModel
     lateinit var binding : ActivityMovieListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        /**
         *activity is injected with dependencies..
         */
        MoviesApplication.daggerMoviesComponent.inject(this)
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_list)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        subscribeForMovies()

    }

    /**
     * observe the changes in live data of @MovieListViewModel for the list of movies
     */
    private fun subscribeForMovies() {
        viewModel.dataState.observe(this,{movieList ->
            movieList.let {
                    binding.movieListRecyclerView.layoutManager = GridLayoutManager(this, 2)
                    val adapter: MovieListAdapter? = MovieListAdapter(movieList, this)

                    adapter?.let {
                        binding.movieListRecyclerView.adapter = adapter
                    }
                }
        }

        )
    }

    override fun onItemClickListener(movie : MovieInfo) {
        val bundle = movie.id
        val intent = Intent(this@MovieListActivity,MovieDetailsActivity::class.java)
        intent.putExtra("id", bundle)
        startActivity(intent)
    }

}