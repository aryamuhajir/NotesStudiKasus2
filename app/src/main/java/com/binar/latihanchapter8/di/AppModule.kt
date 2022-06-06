package com.binar.latihanchapter8.di

import android.app.Application
import com.binar.latihanchapter8.room.NotesDao
import com.binar.latihanchapter8.room.NotesDatabase
import com.binar.latihanchapter8.room.UserDao
import com.binar.latihanchapter8.room.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDB(context: Application) : NotesDatabase{
        return  NotesDatabase.getInstance(context)!!
    }
    @Provides
    @Singleton
    fun provideDBU(context: Application) : UserDatabase{
        return  UserDatabase.getInstance(context)!!
    }

    @Provides
    @Singleton
    fun provideDao(noteDb : NotesDatabase) : NotesDao{
        return  noteDb.favoriteDao()
    }

    @Provides
    @Singleton
    fun provideDaoU(userDB : UserDatabase) : UserDao{
        return  userDB.userDao()
    }


}