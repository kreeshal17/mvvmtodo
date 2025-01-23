package com.krishal.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User_table")
data class User (
    val name:String,
     val email:String,
    @PrimaryKey(autoGenerate = true)
    val  id:Int=0)