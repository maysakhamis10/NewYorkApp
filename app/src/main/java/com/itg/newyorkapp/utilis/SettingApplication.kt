package com.itg.newyorkapp.utilis

import android.app.Application
import com.example.newyorktimes.data.repository.ApiRepository
import com.itg.newyorkapp.data.database.TopStoriesRoomDatabase

class SettingApplication : Application() {

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { TopStoriesRoomDatabase.getDatabase(this) }
   // val repository by lazy { ApiRepository(database.storyDao()) }
}