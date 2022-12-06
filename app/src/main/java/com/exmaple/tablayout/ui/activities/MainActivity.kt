package com.exmaple.tablayout.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.exmaple.tablayout.adapter.ViewPagerAdapter
import com.exmaple.tablayout.databinding.ActivityMainBinding
import com.exmaple.tablayout.ui.fragments.*
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val fragments =
        listOf (
            FragmentOne(),
            FragmentTwo(),
            FragmentThree(),
            FragmentFour(),
            FragmentFive(),
        )

    private val tabTitles = listOf("Egypt", "Canada","France","United States","Australia")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }


    private fun initViewPager() {
        val pagerAdapter = ViewPagerAdapter(this, fragments)
        binding.viewPager.adapter = pagerAdapter
        binding.viewPager.isUserInputEnabled = false
    }
}