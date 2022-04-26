package com.example.rickmortyapp.model.repository

import com.example.rickmortyapp.data.CharactersDataClass
import com.example.rickmortyapp.data.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersDBRepository {

    fun getCharacters() : Call<CharactersDataClass>

    fun getDetails(characterId: String) : Call<Result>
}