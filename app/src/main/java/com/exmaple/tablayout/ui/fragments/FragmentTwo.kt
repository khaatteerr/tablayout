package com.exmaple.tablayout.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmaple.tablayout.R
import com.exmaple.tablayout.adapter.RecyclerViewAdapter
import com.exmaple.tablayout.databinding.FragmentTwoBinding
import com.exmaple.tablayout.networking.API
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentTwo : Fragment() {

    private lateinit var binding:FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
      binding = FragmentTwoBinding.inflate(inflater)

        initRecyclerView()
        return binding.root
    }


    private fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(context)
        binding.canadaRecyclerView.layoutManager = layoutManager

        GlobalScope.launch {

                val data =  API.apiService.getDataFromApi().body()
                withContext(Dispatchers.Main){
                     binding.canadaRecyclerView.adapter= RecyclerViewAdapter(data!!,2)
                }

        }



    }
}