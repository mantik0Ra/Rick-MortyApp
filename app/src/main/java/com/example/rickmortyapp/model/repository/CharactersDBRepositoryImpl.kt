package com.example.rickmortyapp.model.repository

import com.example.rickmortyapp.data.CharactersDataClass
import com.example.rickmortyapp.data.Result
import com.example.rickmortyapp.model.apis.ApiInterface
import com.example.rickmortyapp.model.repository.CharactersDBRepository
import retrofit2.Call

class CharactersDBRepositoryImpl : CharactersDBRepository {

    private val apiInterface = ApiInterface.create()

    override fun getCharacters(): Call<CharactersDataClass> {
        return apiInterface.getCharacters()
    }

    override fun getDetails(characterId: String): Call<Result> {
        return apiInterface.getDetails(characterId)
    }
}