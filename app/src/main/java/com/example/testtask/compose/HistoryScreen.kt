package com.example.testtask.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.example.testtask.room.model.NumberBin

@Composable
fun HistoryScreen(
    list: LiveData<List<NumberBin>>
) {
    val list2 by list.observeAsState()
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .border(width = 2.dp, color = Color.Green)
            .padding(16.dp)
    )
    {
            list2?.forEach { value ->
                HistoryItem(value.bin)
        }
    }
}

