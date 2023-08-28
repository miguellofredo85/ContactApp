package com.example.contactapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

//here implement CRUD
@Dao
interface UserDAO {
    @Insert
    suspend fun insertUser(user:User):Long
    @Update
    suspend fun updateUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    //suspend is for large data management

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("SELECT * FROM user ")
    fun getAllUsersInDB():LiveData<List<User>>
    //custom query
}