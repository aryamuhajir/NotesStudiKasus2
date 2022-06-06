package com.binar.latihanchapter8.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.binar.latihanchapter8.repository.UserRepository
import com.binar.latihanchapter8.room.Notes
import com.binar.latihanchapter8.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelUser @Inject constructor(private val repository : UserRepository) : ViewModel() {
    var userLiveData: MutableLiveData<Int> = MutableLiveData()

    fun registerLive(user : User){
        viewModelScope.launch {
            repository.registerDao(user)
            delay(100)
        }

    }
    fun cekLoginLive(username : String, password : String){
        viewModelScope.launch {
            userLiveData.postValue(repository.cekLoginRepo(username,password))
            delay(100)

        }
    }

}