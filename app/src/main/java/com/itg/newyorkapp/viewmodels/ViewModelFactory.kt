package com.example.newyorktimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newyorktimes.data.apis.ApiHelper
import com.example.newyorktimes.data.repository.ApiRepository
import com.itg.newyorkapp.data.database.StoryDao

class ViewModelFactory(private val apiHelper: ApiHelper,
                       private val storyDao : StoryDao
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

            return MainViewModel(ApiRepository(apiHelper,storyDao)) as T

        }
        throw IllegalArgumentException("Unknown class name")

    }

}