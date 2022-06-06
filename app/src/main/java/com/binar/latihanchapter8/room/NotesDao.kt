package com.binar.latihanchapter8.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface NotesDao {

    @Insert
    fun insertNote(note : Notes) : Long

    @Query("SELECT * FROM notes")
    fun getNotes() : List<Notes>


}