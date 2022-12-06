package com.exmaple.tablayout.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmaple.tablayout.adapter.RecyclerViewAdapter
import com.exmaple.tablayout.databinding.FragmentOneBinding
import com.exmaple.tablayout.model.CountryData
import com.exmaple.tablayout.networking.API
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentOne : Fragment() {

    private lateinit var binding: FragmentOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater)

        initRecyclerView()
        return binding.root
    }



    private fun initRecyclerView() {

        val layoutManager = LinearLayoutManager(context)
        binding.egyptRecyclerView.layoutManager = layoutManager

        GlobalScope.launch {
            try {
              val data =  API.apiService.getDataFromApi()
                Toast.makeText(requireActivity(),"${ API.apiService.getDataFromApi()}",Toast.LENGTH_LONG).show()
            }catch (e:java.lang.Exception){
                Toast.makeText(requireActivity(),"${e.message}",Toast.LENGTH_LONG).show()

            }

        }



    }


}