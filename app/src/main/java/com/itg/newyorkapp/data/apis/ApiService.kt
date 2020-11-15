package com.example.newyorktimes.data.apis

import com.example.newyorktimes.data.datamodels.TopStoriesModel
import com.example.newyorktimes.utilis.Constants
import retrofit2.http.GET

interface ApiService {

    @GET("https://api.nytimes.com/svc/topstories/v2/arts.json?api-key=P1JAkeMZ2nbZm3HV56IPLl02mDE5rhX4")
    @JvmSuppressWildcards
    fun fetchTopStories(): TopStoriesModel

}


