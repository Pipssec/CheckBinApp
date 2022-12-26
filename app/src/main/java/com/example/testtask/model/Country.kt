package com.example.testtask.model

data class Country(
    val alpha2: String,
    val currency: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int? = null,
    val name: String,
    val numeric: String
)