package com.example.newyorktimes.data.repository

import com.example.newyorktimes.data.apis.ApiHelper

class ApiRepository(private val apiHelper: ApiHelper) {

    suspend fun fetchTopStories () = apiHelper.fetchTopStories()

}