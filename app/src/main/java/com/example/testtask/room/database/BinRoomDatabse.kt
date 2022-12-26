package com.example.testtask.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testtask.room.dao.BinDao
import com.example.testtask.room.model.NumberBin

@Database(entities = [NumberBin::class], version = 1)
abstract class BinRoomDatabase: RoomDatabase() {
    abstract fun binDao(): BinDao

    companion object {
        @Volatile
        private var INSTANCE: BinRoomDatabase? = null
        fun getDatabase(context: Context): BinRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, BinRoomDatabase::class.java, "bin_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}