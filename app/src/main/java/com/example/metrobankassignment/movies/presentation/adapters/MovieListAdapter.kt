package com.example.movieapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.metrobankassignment.R
import com.example.metrobankassignment.databinding.MovieItemBinding
import com.example.metrobankassignment.movies.domain.models.MovieInfo
import com.example.metrobankassignment.movies.util.interfaces.onClickListener

/**
 * @MovieListAdapter class shows movie list
 */
class MovieListAdapter(private val movieList : List<MovieInfo>, private val listener : onClickListener) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):  MovieViewHolder{
        val binding: MovieItemBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_item, parent,false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.addData(movieList[position],listener)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }
    class MovieViewHolder(private val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun addData(item: MovieInfo, listener: onClickListener){

            binding.movieitem = item


            binding.imageView.setOnClickListener {
                listener.onItemClickListener(item)
            }
        }
    }

}


