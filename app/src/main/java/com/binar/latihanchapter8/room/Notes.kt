package com.binar.latihanchapter8.room

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
@Entity
@Parcelize
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,
    @ColumnInfo(name = "title")
    var title : String,
    @ColumnInfo(name =  "content")
    var content: String,
    @ColumnInfo( name ="date")
    var date: String,
    @ColumnInfo( name ="category")
    var category: String
) : Parcelable
