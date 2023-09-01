package com.example.contactapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

//here implement CRUD
@Dao
interface UserDAO {
    @Upsert
    suspend fun upsertUser(user: User)
    @Delete
    suspend fun deleteUser(user: User)
    //suspend is for large data management

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("SELECT * FROM user ORDER BY user_name ASC")
    fun getAllUsersInDB():LiveData<List<User>>
    //custom query
}