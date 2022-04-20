package com.example.myapplication.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.adapter.notesAdapter
import com.example.myapplication.viewmodel.notesViewModel


class home : androidx.fragment.app.Fragment() {

lateinit var binding: FragmentHomeBinding
    val viewModel: notesViewModel by viewModels()
override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding= FragmentHomeBinding.inflate(layoutInflater,container,false)

    viewModel.getnotes().observe(viewLifecycleOwner,{noteslist->
         binding.recyclerview.layoutManager=GridLayoutManager(requireContext(),2)
        binding.recyclerview.adapter=notesAdapter(requireContext(),noteslist)
    })
    binding.filter.setOnClickListener{
        viewModel.getnotes().observe(viewLifecycleOwner,{noteslist->
            binding.recyclerview.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recyclerview.adapter=notesAdapter(requireContext(),noteslist)
        })
    }
    binding.highFilter.setOnClickListener{
        viewModel.gethighnotes().observe(viewLifecycleOwner,{noteslist->
            binding.recyclerview.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recyclerview.adapter=notesAdapter(requireContext(),noteslist)
        })
    }
    binding.mediumFilter.setOnClickListener{
        viewModel.getmediumnotes().observe(viewLifecycleOwner,{noteslist->
            binding.recyclerview.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recyclerview.adapter=notesAdapter(requireContext(),noteslist)
        })
    }
    binding.lowFilter.setOnClickListener{
        viewModel.getlownotes().observe(viewLifecycleOwner,{noteslist->
            binding.recyclerview.layoutManager=GridLayoutManager(requireContext(),2)
            binding.recyclerview.adapter=notesAdapter(requireContext(),noteslist)
        })
    }
        binding.btnAddnotes.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_home2_to_create)
        }
        return binding.root
    }


}