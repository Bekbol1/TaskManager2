package com.example.taskmanager2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskmanager2.R
import com.example.taskmanager2.databinding.FragmentHomeBinding
import com.example.taskmanager2.model.Task
import com.example.taskmanager2.ui.task.TaskFragment.Companion.RESULT_KEY
import com.example.taskmanager2.ui.task.TaskFragment.Companion.RESULT_REQUEST_KEY
import com.example.taskmanager2.ui.task.adapter.TaskAdapter

class HomeFragment : Fragment() {
    private val adapter = TaskAdapter()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setFragmentResultListener(RESULT_REQUEST_KEY, { _ , bundle ->
            val data = bundle.getSerializable(RESULT_KEY) as Task
            adapter.addTask(data)
        })
        binding.fab.setOnClickListener { findNavController().navigate(R.id.taskFragment) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}