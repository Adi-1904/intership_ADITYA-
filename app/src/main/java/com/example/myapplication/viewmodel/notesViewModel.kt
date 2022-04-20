package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Database.Notes_Database
import com.example.myapplication.Repository.repository
import com.example.myapplication.model.notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class notesViewModel(application: Application) : AndroidViewModel(application) {
    val repository:repository
    init {
        val dao=Notes_Database.getdatabaseinstance(application).notesDao()
        repository= repository(dao)

    }
    fun addnotes(notes: notes)
    {
        repository.insertfinalnotes(notes)
    }
    fun getnotes():LiveData<List<notes>> =  repository.getfinalnotes()
    fun gethighnotes():LiveData<List<notes>> =  repository.gethighnotes()
    fun getmediumnotes():LiveData<List<notes>> =  repository.getmediumnotes()
    fun getlownotes():LiveData<List<notes>> =  repository.getlownotes()


    fun deletenotes(id:Int)=viewModelScope.launch (Dispatchers.IO)
    {
        repository.deletefinalnote(id)
    }
    fun updatenotes(notes: notes)
    {
        repository.updatefinalnotes(notes)
    }
}