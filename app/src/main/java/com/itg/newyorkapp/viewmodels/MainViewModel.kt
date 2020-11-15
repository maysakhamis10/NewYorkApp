package com.example.newyorktimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.newyorktimes.data.apis.Resource
import com.example.newyorktimes.data.repository.ApiRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val apiRepository : ApiRepository) : ViewModel() {

     fun fetchTopStoriesLiveData () = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiRepository.fetchTopStories()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}