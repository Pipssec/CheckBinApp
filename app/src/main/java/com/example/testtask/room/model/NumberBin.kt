package com.example.testtask.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_Bin")
data class NumberBin(
    @PrimaryKey
    @ColumnInfo(name = "numberBin")
    val bin: Long
){

}

