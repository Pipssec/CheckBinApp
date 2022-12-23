package com.example.testtask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testtask.databinding.ActivityMainBinding
import com.example.testtask.fragments.StartFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportFragmentManager.beginTransaction()
            .add(R.id.activity_container, StartFragment())
            .commit()
    }
}