package com.exmaple.tablayout.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmaple.tablayout.R
import com.exmaple.tablayout.adapter.RecyclerViewAdapter
import com.exmaple.tablayout.databinding.FragmentThreeBinding
import com.exmaple.tablayout.networking.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FragmentThree : Fragment() {

    private lateinit var binding :FragmentThreeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding =FragmentThreeBinding.inflate(inflater)

        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(context)
        binding.faranaRecyclerView.layoutManager = layoutManager

        GlobalScope.launch {

            val data =  API.apiService.getDataFromApi().body()
            withContext(Dispatchers.Main){
                binding.faranaRecyclerView.adapter= RecyclerViewAdapter(data!!,3)
            }

        }



    }
}