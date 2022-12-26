package com.example.testtask.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.example.testtask.room.model.NumberBin

@Composable
fun HistoryScreen(
    list: LiveData<List<NumberBin>>
) {
    val list2 by list.observeAsState()
    Column {

            list2?.forEach { value ->
                HistoryItem(value.bin)
        }
    }
}

