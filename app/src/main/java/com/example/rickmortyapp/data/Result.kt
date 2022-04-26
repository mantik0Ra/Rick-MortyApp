package com.example.rickmortyapp.data

import com.example.rickmortyapp.data.Location
import com.example.rickmortyapp.data.Origin

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)