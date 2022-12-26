package com.example.testtask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testtask.BinApplication
import com.example.testtask.BinRoomViewModel
import com.example.testtask.BinViewModelFactory
import com.example.testtask.compose.HistoryScreen
import com.example.testtask.databinding.FragmentHistoryBinding

class HistoryFragment:Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private val binRoomViewModel: BinRoomViewModel by viewModels(){
        BinViewModelFactory((context?.applicationContext as BinApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.deleteBtn.setOnClickListener {
            binRoomViewModel.delete()
        }
        binding.composeView.setContent {
            MaterialTheme {
                HistoryScreen(binRoomViewModel.allWords)
            }
       }
    }
}