package com.example.newyorktimes.data.apis

class ApiHelper(private val apiService: ApiService) {

    suspend fun fetchTopStories() = apiService.fetchTopStories()
}