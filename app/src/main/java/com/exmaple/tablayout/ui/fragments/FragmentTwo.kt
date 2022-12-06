package com.exmaple.tablayout.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exmaple.tablayout.R
import com.exmaple.tablayout.databinding.FragmentTwoBinding
import com.squareup.picasso.Picasso


class FragmentTwo : Fragment() {

    private lateinit var binding:FragmentTwoBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
      binding = FragmentTwoBinding.inflate(inflater)

        Picasso.get()
            .load("https://cdn.britannica.com/39/7139-050-A88818BB/Himalayan-chocolate-point.jpg")
            .into(binding.imageView2)

        return binding.root
    }


}