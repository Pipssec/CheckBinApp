package com.example.testtask.model

data class BIN(
    val bank: Bank,
    val brand: String,
    val country: Country,
    val number: Number,
    val prepaid: Boolean? = null,
    val scheme: String,
    val type: String
)

