package com.example.myapplication.Repository

import androidx.lifecycle.LiveData
import com.example.myapplication.model.notes
import com.example.myapplication.model.notesDao


class repository(val dao: notesDao) {
    fun getfinalnotes():LiveData<List<notes>>{
        return dao.getnotes()
    }
    fun gethighnotes():LiveData<List<notes>>{
        return dao.gethighnotes()
    }
    fun getmediumnotes():LiveData<List<notes>>{
        return dao.getmediumnotes()
    }
    fun getlownotes():LiveData<List<notes>>{
        return dao.getlownotes()
    }
    fun insertfinalnotes(notes: notes)
    {
        dao.Insertnotes(notes)
    }
    fun deletefinalnote(id:Int)
    {
        dao.delete(id)
    }
    fun updatefinalnotes(notes: notes)
    {
        dao.update(notes)
    }
}