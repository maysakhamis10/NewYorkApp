package com.itg.newyorkapp.data.database

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newyorktimes.data.datamodels.ResultStories

interface StoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllStores(story :  ArrayList<ResultStories>)


    @Query("SELECT * FROM top_stories ")
    suspend  fun fetchAllTopStories() :ArrayList<ResultStories>

}