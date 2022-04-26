package com.example.rickmortyapp.data

import com.example.rickmortyapp.data.Info
import com.example.rickmortyapp.data.Result

data class CharactersDataClass(
    val info: Info,
    val results: List<Result>
)