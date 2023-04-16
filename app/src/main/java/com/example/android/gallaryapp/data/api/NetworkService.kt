package com.example.android.gallaryapp.data.api

import com.example.android.gallaryapp.data.model.Photos
import com.example.android.gallaryapp.data.model.pics
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET("/services/rest/")
    suspend fun getPhotos(
        @Query("method") method: String,
        @Query("per_page") per_page: String,
        @Query("page") page: Int,
        @Query("api_key") api_key: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String,
        @Query("extras") extras: String
    ): Response<pics>


    @GET("/services/rest/")
    suspend fun getPhotosSearch(
        @Query("method") method: String,
        @Query("per_page") per_page: String,
        @Query("page") page: Int,
        @Query("api_key") api_key: String,
        @Query("format") format: String,
        @Query("nojsoncallback") nojsoncallback: String,
        @Query("extras") extras: String,
        @Query("text") text: String
    ): Response<pics>
}







 