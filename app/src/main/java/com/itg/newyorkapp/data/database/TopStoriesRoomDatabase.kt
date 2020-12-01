package com.itg.newyorkapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newyorktimes.data.datamodels.ResultStories

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = arrayOf(ResultStories::class), version = 1, exportSchema = false)
public abstract class TopStoriesRoomDatabase : RoomDatabase() {

    abstract fun storyDao(): StoryDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: TopStoriesRoomDatabase? = null

        fun getDatabase(context: Context): TopStoriesRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TopStoriesRoomDatabase::class.java,
                    "story_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}