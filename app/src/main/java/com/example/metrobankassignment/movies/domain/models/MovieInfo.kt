package com.example.metrobankassignment.movies.domain.models

import com.example.metrobankassignment.movies.data.dto.RelatedMovy
import com.google.gson.annotations.SerializedName

data class MovieInfo(
 val box_office: String?,
 val chronology: Int?,
 val cover_url: String?,
 val directed_by: String?,
 val id: Int?,
 val imdb_id: String?,
 val overview: String?,
 val phase: Int?,
 val release_date: String?,
 val saga: String?,
 val title: String?,
)
