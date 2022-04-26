package com.example.rickmortyapp.view1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmortyapp.data.CharactersDataClass
import com.example.rickmortyapp.data.Result
import com.example.rickmortyapp.databinding.ActivityMainBinding
import com.example.rickmortyapp.model.apis.ApiInterface
import com.example.rickmortyapp.view1.adapters.CustomAdapter
import com.example.rickmortyapp.viewmodel.CharactersViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), CustomAdapter.ItemClickListener {

    private val mViewModel: CharactersViewModel = CharactersViewModel()
    private lateinit var mCharactersRecyclerView: RecyclerView
    private lateinit var mCharactersAdapter: CustomAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        initObservers()
        mViewModel.getCharacters()


    }

    override fun onItemClick(id: Int) {
        val intent = Intent(this@MainActivity, CharacterDetailsActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }
    private fun initViews() {
        mCharactersRecyclerView = binding.recyclerView
        mCharactersRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun initObservers() {
        mViewModel.apply {
            characters.observe(this@MainActivity) {
                mCharactersAdapter = CustomAdapter(it as List<Result>?, this@MainActivity)
                mCharactersRecyclerView.adapter = mCharactersAdapter
            }
        }
    }
}
