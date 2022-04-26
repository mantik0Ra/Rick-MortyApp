package com.example.rickmortyapp.model.apis

import com.example.rickmortyapp.data.CharactersDataClass
import com.example.rickmortyapp.data.Result
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiInterface {

    @GET("character/")
    fun getCharacters() : Call<CharactersDataClass>

    @GET("character/{character_id}")
    fun getDetails(@Path("character_id") characterId: String) : Call<Result>

    companion object {

        var BASE_URL = "https://rickandmortyapi.com/api/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }

}