package com.binar.latihanchapter8.repository

import com.binar.latihanchapter8.room.Notes
import com.binar.latihanchapter8.room.NotesDao
import javax.inject.Inject

class NotesRepository @Inject constructor(private val dao : NotesDao) {
    fun getAllNotes() : List<Notes>{
        return dao.getNotes()
    }

    fun insertNote(note : Notes){
        dao.insertNote(note)

    }
}