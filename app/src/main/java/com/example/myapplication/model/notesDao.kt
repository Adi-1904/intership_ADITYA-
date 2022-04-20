package com.example.myapplication.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface notesDao {
    @Query("SELECT * FROM Notes")
    fun getnotes():LiveData<List<notes>>
    @Query("SELECT * FROM Notes WHERE priority IS  1")
    fun gethighnotes():LiveData<List<notes>>
    @Query("SELECT * FROM Notes WHERE priority IS  2")
    fun getmediumnotes():LiveData<List<notes>>
    @Query("SELECT * FROM Notes WHERE priority IS  3")
    fun getlownotes():LiveData<List<notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun Insertnotes(notes: notes)

    @Query("DELETE FROM Notes WHERE Id=:Id")
    fun delete(Id:Int)

    @Update
    fun update(notes: notes)
}