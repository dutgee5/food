package com.example.food.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.food.databinding.FragmentHomeBinding
import com.example.food.ui.adapter.ProductAdapter
import com.example.food.ui.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel:HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater,container,false)



        viewModel.liste.observe(viewLifecycleOwner){ //dinleme
            val yemekAdapter= ProductAdapter(requireContext(),it,viewModel)
            binding.recyclerFoods.adapter =yemekAdapter

        }

        binding.recyclerFoods.layoutManager =StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.yemek()
    }

}