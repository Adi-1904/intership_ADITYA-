package com.example.myapplication.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.notes
import com.example.myapplication.model.notesDao

@Database(entities = [notes::class],version = 1,exportSchema = false)
abstract class Notes_Database:RoomDatabase() {
    abstract fun notesDao():notesDao
    companion object{
        @Volatile
        var instance:Notes_Database?=null
        fun getdatabaseinstance(context: Context):Notes_Database{
            val tempinstance= instance
            if(tempinstance!=null)
            {
                return tempinstance
            }
            synchronized(this)
            {
                    val roomdatabaseinstance=Room.databaseBuilder(context,Notes_Database::class.java,"Notes").allowMainThreadQueries().build()
                instance=roomdatabaseinstance
                return return roomdatabaseinstance
            }

        }
    }
}