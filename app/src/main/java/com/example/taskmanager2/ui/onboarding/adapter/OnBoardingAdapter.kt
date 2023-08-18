package com.example.taskmanager2.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskmanager2.databinding.ItemOnboardingBinding
import com.example.taskmanager2.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {

    private val data = arrayListOf<OnBoarding>(
        OnBoarding("Reflect","Reflect your success with Task Manager!","https://uploads-ssl.webflow.com/6156c92cb3f1a26201745fa2/621b22f337c639bd78db0963_6197773c733ba15f7b3da1da_20943650-min.jpg"),
        OnBoarding("Track Progress","You can easily track your daily progress!","https://img.freepik.com/free-vector/hand-drawn-business-planning-with-task-list_23-2149164275.jpg"),
        OnBoarding("Perform","Perform your tasks efficiently!","https://miro.medium.com/max/1400/1*8ygFKYb0Yo6Hc-vnScGA9A.png")
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
            Glide.with(binding.ivBoard).load(onBoarding.image).into(binding.ivBoard)

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