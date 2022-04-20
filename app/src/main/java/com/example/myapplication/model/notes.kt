package com.example.myapplication.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Notes")



@Parcelize

class notes (
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null,
    var title:String,
    var notes: String,
    var date:String,
    var priority:String

    ) : Parcelable