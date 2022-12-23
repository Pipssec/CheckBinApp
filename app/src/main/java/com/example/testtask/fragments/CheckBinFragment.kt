package com.example.testtask.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.testtask.ViewModel
import com.example.testtask.databinding.FragmentCheckBinding


class CheckBinFragment:Fragment() {
    private lateinit var binding: FragmentCheckBinding
    private val viewModel: ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentCheckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.checkInputBtn.setOnClickListener {
            val inputText = binding.inputBinEt.text.toString().toLong()
            viewModel.checkBin(inputText)
        }
            viewModel.resultBin.observe(viewLifecycleOwner, Observer {
                binding.schemeNetworkAnswerTv.text = it?.scheme.toString().capitalize()
                binding.lengthAnswerTv.text = it?.number?.length.toString()
                binding.brandAnswerTv.text = it?.brand.toString()
                binding.luhnAnswerTv.text= it?.number?.luhn.toString()
                binding.typeAnswerTv.text = it?.type.toString()
                binding.prepaidAnswerTv.text = it?.prepaid.toString()
                binding.countryNameTv.text = it?.country?.name.toString()
                binding.emojiTv.text =  it?.country?.emoji.toString()
                binding.bankCityTv.text = it?.bank?.city.toString()
                binding.bankNameTv.text = it?.bank?.name.toString()
                binding.bankUrlTv.text = it?.bank?.url.toString()
                binding.bankPhoneTv.text = it?.bank?.phone.toString()
            })

    }
}