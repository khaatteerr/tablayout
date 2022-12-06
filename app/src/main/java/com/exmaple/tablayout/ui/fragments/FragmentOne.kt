package com.exmaple.tablayout.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmaple.tablayout.adapter.RecyclerViewAdapter
import com.exmaple.tablayout.databinding.FragmentOneBinding
import com.exmaple.tablayout.networking.API
import kotlinx.coroutines.*


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
              val data =  API.apiService.getDataFromApi().body()
                withContext(Dispatchers.Main){
                    Toast.makeText(requireActivity(),"${ API.apiService.getDataFromApi()}",Toast.LENGTH_LONG).show()
                    binding.egyptRecyclerView.adapter=RecyclerViewAdapter(data!!,1)
                }
            }catch (e:java.lang.Exception){

                withContext(Dispatchers.Main){
                    Toast.makeText(requireActivity(),"${e.message}",Toast.LENGTH_LONG).show()

                }

            }

        }



    }


}