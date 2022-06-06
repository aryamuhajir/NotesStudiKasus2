package com.binar.latihanchapter8.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.latihanchapter8.repository.NotesRepository
import com.binar.latihanchapter8.room.Notes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelNotes @Inject constructor(private val repository : NotesRepository) : ViewModel() {
    var noteLiveData: MutableLiveData<List<Notes>> = MutableLiveData()


    private fun getAllFavLive(){
        viewModelScope.launch {
            val list = repository.getAllNotes()
            delay(100)
            noteLiveData.postValue(list)
        }
    }

    fun insertNoteLive(note : Notes){
        viewModelScope.launch {
            repository.insertNote(note)
            delay(2000)
            getAllFavLive()
        }

    }
//    fun deleteFavLive(id : String, email: String){
//        viewModelScope.launch {
//            repository.deleteFavRepo(id, email)
//            delay(2000)
//            getAllFavLive(email)
//
//        }
//    }
//    fun cekFavLiveData(id : String, email: String){
//        viewModelScope.launch {
//            val cek = repository.cekRepo(id, email)
//
//            cekData.postValue(cek)
//        }
//    }

}