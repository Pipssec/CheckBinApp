package com.example.testtask

import android.app.Application
import com.example.testtask.room.database.BinRoomDatabase
import com.example.testtask.room.repository.BinRepository

class BinApplication: Application() {
    val database by lazy { BinRoomDatabase.getDatabase(this) }
    val repository by lazy { BinRepository(database.binDao()) }
}