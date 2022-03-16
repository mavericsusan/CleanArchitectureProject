package com.example.metrobankassignment.movies.data.di.module

import com.example.metrobankassignment.movies.data.remote.MovieApiService
import com.example.metrobankassignment.movies.util.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**@Module informs Dagger that this class is a Dagger Module
 * Dagger module class for api calling and retrofit instance creation
 */
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun moviesApi(retrofit: Retrofit) : MovieApiService {
        return retrofit.create(MovieApiService::class.java)
    }

    @Singleton
    @Provides
    fun getRetrofit(gsonConverterFactory: GsonConverterFactory) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun getGsonConvertFactory(gson: Gson) : GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    fun getGSON() : Gson {
        return GsonBuilder().create()
    }
}