package com.example.rickmortyapp.view1.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmortyapp.view1.MainActivity
import com.example.rickmortyapp.R
import com.example.rickmortyapp.data.Result
import com.squareup.picasso.Picasso


class CustomAdapter(private val mList: List<Result>?,
                    val mItemClickListener: MainActivity
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                mList?.get(position)?.id?.let { it -> mItemClickListener.onItemClick(it)}
            }
        }

        val imageView = itemView.findViewById<ImageView>(R.id.image_card_view)
        val nameView = itemView.findViewById<TextView>(R.id.name_card_view)
        val raceView = itemView.findViewById<TextView>(R.id.race_card_view)
        val genderView = itemView.findViewById<TextView>(R.id.gender_card_view)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = mList?.get(position)
        Picasso.get().load("${ItemsViewModel?.image}").into(holder.imageView)
        holder.nameView.text = ItemsViewModel?.name
        holder.raceView.text = ItemsViewModel?.species
        holder.genderView.text = ItemsViewModel?.gender


    }

    override fun getItemCount(): Int {
        return mList!!.size
    }
}