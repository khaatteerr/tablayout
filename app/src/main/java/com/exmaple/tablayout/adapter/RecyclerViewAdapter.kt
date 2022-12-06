package com.exmaple.tablayout.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exmaple.tablayout.R
import com.exmaple.tablayout.databinding.RecyclerItemRowBinding
import com.exmaple.tablayout.model.Country
import com.exmaple.tablayout.model.CountryData
import com.exmaple.tablayout.model.EGYPT
import com.exmaple.tablayout.ui.activities.DetailsActivity
import com.squareup.picasso.Picasso
import retrofit2.Response

class RecyclerViewAdapter(private val list:  CountryData  ) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerItemRowBinding.bind(view)

        fun bind(list: CountryData) {

            Picasso.get()
                .load(list.EGYPT?.get(position)?.url)
                .into(binding.countryImage)

            binding.countryName.text = list.EGYPT?.get(position)?.name
            binding.details.text=list.EGYPT?.get(position)?.describtion

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_row, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list)

        holder.itemView.setOnClickListener {

            val i = Intent(holder.itemView.context, DetailsActivity::class.java)
            it.context.startActivity(i)
        }
    }

    override fun getItemCount() = 5
}