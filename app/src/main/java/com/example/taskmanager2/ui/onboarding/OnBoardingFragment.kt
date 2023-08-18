package com.example.taskmanager2.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.R
import com.example.taskmanager2.databinding.FragmentOnBoardingBinding
import com.example.taskmanager2.ui.onboarding.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var indicator: CircleIndicator
    private val adapter = OnBoardingAdapter(this::onClick)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentOnBoardingBinding.inflate(inflater,container,false)
        return binding.root}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        super.onViewCreated(view, savedInstanceState)
        binding.viewpager.adapter = adapter
        binding.indicator.setViewPager(binding.viewpager)
    }
    private fun onClick(){
        findNavController().navigate(R.id.navigation_home)
    }
}