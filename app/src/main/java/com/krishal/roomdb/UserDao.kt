package com.krishal.roomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
 interface UserDao{


     @Insert(onConflict = OnConflictStrategy.IGNORE)
     suspend fun  insertUser(user:User)

     @Delete
     suspend fun deleteUser(user:User)

     @Query("SELECT * FROM user_table WHERE id=:id ORDER BY id Asc")
      fun getUser(id:Int):LiveData<User>




    @Query("SELECT * FROM user_table  ORDER BY id Asc")
      fun getAllUser():LiveData<List<User>>










 }



