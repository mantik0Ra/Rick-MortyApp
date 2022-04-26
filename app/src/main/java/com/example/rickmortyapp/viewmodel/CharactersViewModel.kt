package com.example.rickmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.rickmortyapp.data.CharactersDataClass
import com.example.rickmortyapp.data.Result
import com.example.rickmortyapp.model.repository.CharactersDBRepository
import com.example.rickmortyapp.model.repository.CharactersDBRepositoryImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersViewModel {

    private val _characters = MutableLiveData<List<Result?>>()
    val characters : LiveData<List<Result?>> = _characters

    private val _charactersDetails = MutableLiveData<Result?>()
    val charactersDetails : LiveData<Result?> = _charactersDetails

    private val mCharactersRepository : CharactersDBRepository = CharactersDBRepositoryImpl()

    fun getCharacters() {
        val response = mCharactersRepository.getCharacters()
        response.enqueue(object : Callback<CharactersDataClass> {
            override fun onResponse(call: Call<CharactersDataClass>, response: Response<CharactersDataClass>) {
                _characters.postValue(response.body()?.results)
            }

            override fun onFailure(call: Call<CharactersDataClass>, t: Throwable) {
                Log.d("testLogs", "onFailure : ${t.message}")
            }
        })
    }

    fun getDetails(characterId: String) {
        val response = mCharactersRepository.getDetails(characterId)
        response.enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>?, response: Response<Result?>) {
                _charactersDetails.postValue(response.body())
            }

            override fun onFailure(call: Call<Result?>, t: Throwable) {
                Log.d("testLogs", "onFailure : ${t.message}")
            }

        })
    }
}