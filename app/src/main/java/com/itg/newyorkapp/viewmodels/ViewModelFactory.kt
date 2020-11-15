package com.example.newyorktimes.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newyorktimes.data.apis.ApiHelper
import com.example.newyorktimes.data.repository.ApiRepository

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

            return MainViewModel(ApiRepository(apiHelper)) as T

        }
        throw IllegalArgumentException("Unknown class name")

    }

}