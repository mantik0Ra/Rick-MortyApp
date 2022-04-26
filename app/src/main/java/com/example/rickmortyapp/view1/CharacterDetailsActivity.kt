package com.example.rickmortyapp.view1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.rickmortyapp.R
import com.example.rickmortyapp.data.Result
import com.example.rickmortyapp.databinding.ActivityCharacterDetailsBinding
import com.example.rickmortyapp.model.apis.ApiInterface
import com.example.rickmortyapp.viewmodel.CharactersViewModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterDetailsActivity : AppCompatActivity() {
    private val mViewModel = CharactersViewModel()

    private lateinit var nameDetailsView: TextView
    private lateinit var raceDetailsView: TextView
    private lateinit var genderDetailsView: TextView
    private lateinit var locationDetailsView: TextView
    private lateinit var statusDetailsView: TextView
    private lateinit var episodeDetailsView: TextView
    private lateinit var imageDetailsView: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_details)


        val id = intent.getIntExtra("id", 0)
        initViews()
        initObservers()
        mViewModel.getDetails("$id")

    }
    private fun initObservers() {
        mViewModel.apply {
            charactersDetails.observe(this@CharacterDetailsActivity) {
                setCharactersInformation(it)
            }
        }
    }

    private fun setCharactersInformation(details: Result?) {
        nameDetailsView.text = "${getString(R.string.name)} ${details?.name}"
        raceDetailsView.text = "${getString(R.string.race)} ${details?.species}"
        genderDetailsView.text = "${getString(R.string.gender)} ${details?.gender}"
        locationDetailsView.text = "${getString(R.string.location)} ${details?.location?.name}"
        statusDetailsView.text = "${getString(R.string.status)} ${details?.status}"
        episodeDetailsView.text = "${getString(R.string.episodes)} ${details?.episode?.size}"
        Picasso.get().load(details?.image).into(imageDetailsView)

    }

    private fun initViews() {
        nameDetailsView = findViewById(R.id.name_details_view)
        raceDetailsView = findViewById(R.id.race_deailts_view)
        genderDetailsView = findViewById(R.id.gender_details_view)
        locationDetailsView = findViewById(R.id.location_details_view)
        statusDetailsView = findViewById(R.id.status_details_view)
        episodeDetailsView = findViewById(R.id.episode_details_view)
        imageDetailsView = findViewById(R.id.image_details_view)
    }
}