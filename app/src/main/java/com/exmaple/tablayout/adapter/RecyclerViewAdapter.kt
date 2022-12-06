package com.exmaple.tablayout.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exmaple.tablayout.R
import com.exmaple.tablayout.databinding.RecyclerItemRowBinding
import com.exmaple.tablayout.model.CountryData
import com.exmaple.tablayout.ui.activities.DetailsActivity
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val list: CountryData, val code: Int) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = RecyclerItemRowBinding.bind(view)

        fun bind(list: CountryData) {
            val egypt = list.EGYPT
            val canada = list.Canada
            val far = list.FRANCS
            val usd = list.UnitedStates
            val australia = list.Australia


                    Picasso.get()
                        .load(egypt?.get(position)?.url)
                        .into(binding.countryImage)

                    binding.countryName.text = egypt?.get(position)?.name
                    binding.details.text = egypt?.get(position)?.describtion


                    Picasso.get()
                        .load(canada?.get(position)?.url)
                        .into(binding.countryImage)

                    binding.countryName.text = canada?.get(position)?.name
                    binding.details.text = canada?.get(position)?.describtion

                    Picasso.get()
                        .load(far?.get(position)?.url)
                        .into(binding.countryImage)

                    binding.countryName.text = far?.get(position)?.name
                    binding.details.text = far?.get(position)?.describtion

                    Picasso.get()
                        .load(usd?.get(position)?.url)
                        .into(binding.countryImage)

                    binding.countryName.text = usd?.get(position)?.name
                    binding.details.text = usd?.get(position)?.describtion

                    Picasso.get()
                        .load(australia?.get(position)?.url)
                        .into(binding.countryImage)

                    binding.countryName.text = australia?.get(position)?.name
                    binding.details.text = australia?.get(position)?.describtion

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