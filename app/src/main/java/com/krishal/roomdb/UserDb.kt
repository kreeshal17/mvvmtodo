package com.krishal.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase




@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDb :RoomDatabase() {
    abstract fun dao():UserDao


    companion object{
        @Volatile
        private var Instance:UserDb?=null



        fun  getDatabase(context: Context):UserDb
        {
            if(Instance==null)
            {
                synchronized(this)
                {
                    if(Instance==null)
                    {
                        Instance= Room.databaseBuilder(context.applicationContext,UserDb::class.java,"User_table").build().also { Instance=it }

                    }
                }

            }
            return Instance!!

        }







    }



}