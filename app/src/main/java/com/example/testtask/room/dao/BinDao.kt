package com.example.testtask.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testtask.room.model.NumberBin

@Dao
interface BinDao{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(number: NumberBin)

    @Query("SELECT * FROM number_Bin")
    fun getNumbers(): LiveData<List<NumberBin>>

    @Query("DELETE FROM number_Bin")
    suspend fun deleteAll()
}