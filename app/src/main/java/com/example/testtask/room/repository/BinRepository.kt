package com.example.testtask.room.repository

import androidx.lifecycle.LiveData
import com.example.testtask.room.dao.BinDao
import com.example.testtask.room.model.NumberBin

class BinRepository(private val binDao: BinDao) {
    val allNumbers: LiveData<List<NumberBin>> = binDao.getNumbers()

    suspend fun insert(number: NumberBin){
        binDao.insert(number)
    }

    suspend fun delete(){
        binDao.deleteAll()
    }

}