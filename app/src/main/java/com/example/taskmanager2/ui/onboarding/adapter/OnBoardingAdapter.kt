package com.example.taskmanager2.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.taskmanager2.R
import com.example.taskmanager2.databinding.ItemOnboardingBinding
import com.example.taskmanager2.model.OnBoarding


class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf<OnBoarding>(
        OnBoarding("Reflect","Reflect your success with Task Manager!", "onboard.json"),
        OnBoarding("Track Progress","You can easily track your daily progress!","animationone.json"),
        OnBoarding("Perform","Perform your tasks efficiently!","animationtwo.json")
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            (ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(data.get(position))
    }

    inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onBoarding: OnBoarding) {
            binding.tvTitle.text = onBoarding.title
            binding.tvDesc.text = onBoarding.desc
            val animationView = binding.ivBoard

                val resourceId = itemView.context.resources.getIdentifier(
                    onBoarding.image,
                    "raw",
                    itemView.context.packageName
                )
            animationView.setAnimation(resourceId)
            animationView.playAnimation()

            binding.btnStart.isVisible = adapterPosition == data.lastIndex
            binding.skip.isVisible = adapterPosition != data.lastIndex


            binding.btnStart.setOnClickListener {
                onClick()
            }
            binding.skip.setOnClickListener {
                onClick()
            }
        }
    }

}