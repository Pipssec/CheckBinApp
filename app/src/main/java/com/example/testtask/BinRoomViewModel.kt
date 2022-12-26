package com.example.testtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.testtask.room.model.NumberBin
import com.example.testtask.room.repository.BinRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BinRoomViewModel(var repository: BinRepository): ViewModel() {
    private val _allWords: LiveData<List<NumberBin>> = repository.allNumbers
    val allWords: LiveData<List<NumberBin>>
        get()= _allWords


    fun insert(number: NumberBin) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(number)
    }

    fun delete() = viewModelScope.launch(Dispatchers.IO) {
        repository.delete()
    }
}
class BinViewModelFactory(private val repository: BinRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BinRoomViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BinRoomViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}