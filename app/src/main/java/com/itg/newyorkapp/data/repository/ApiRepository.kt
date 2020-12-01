package com.example.newyorktimes.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import com.example.newyorktimes.data.apis.ApiHelper
import com.example.newyorktimes.data.datamodels.ResultStories
import com.itg.newyorkapp.data.database.StoryDao

class ApiRepository(private val apiHelper: ApiHelper,
                    private val storyDao : StoryDao) {

    suspend fun fetchTopStories () = apiHelper.fetchTopStories()


    suspend fun addTopStoriesToDataBase (){
        try {
            var topStories = fetchTopStories().results
            storyDao.insertAllStores(topStories)
        } catch (cause: Throwable) {
            // If anything throws an exception, inform the caller
            Log.e("ERROR IN ADDING $cause","okay")
        }
    }

}