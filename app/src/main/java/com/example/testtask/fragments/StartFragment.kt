package com.example.testtask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testtask.R
import com.example.testtask.databinding.FragmentStartBinding

class StartFragment: Fragment() {
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.checkBinBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.replace(R.id.activity_container, CheckBinFragment())
                ?.commit()
        }
        binding.historyBtn.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.replace(R.id.activity_container, HistoryFragment())
                ?.commit()
        }
    }
}