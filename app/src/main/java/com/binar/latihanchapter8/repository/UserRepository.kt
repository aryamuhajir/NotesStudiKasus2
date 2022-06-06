package com.binar.latihanchapter8.repository

import com.binar.latihanchapter8.room.User
import com.binar.latihanchapter8.room.UserDao
import javax.inject.Inject


class UserRepository @Inject constructor(private val dao : UserDao) {

    suspend fun registerDao(user : User){
        dao.register(user)
    }
    suspend fun cekLoginRepo(user : String, password : String) : Int{
        return dao.cekLogin(user, password)
    }
}