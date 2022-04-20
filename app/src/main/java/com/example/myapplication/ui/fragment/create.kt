package com.example.myapplication.ui.fragment

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCreateBinding
import com.example.myapplication.model.notes
import com.example.myapplication.viewmodel.notesViewModel
import java.time.LocalDateTime
import java.util.*

class create : Fragment() {
     var priority="1"
    val viewModel:notesViewModel by viewModels()
    lateinit var binding: FragmentCreateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentCreateBinding.inflate(layoutInflater,container,false)
        binding.red.setImageResource(R.drawable.save_24)
        binding.red.setOnClickListener{
            priority="1"
            binding.red.setImageResource(R.drawable.save_24)
            binding.yellow.setImageResource(0)
            binding.green.setImageResource(0)

        }
        binding.yellow.setOnClickListener{
            priority="2"
            binding.yellow.setImageResource(R.drawable.save_24)
            binding.red.setImageResource(0)
            binding.green.setImageResource(0)

        }
        binding.green.setOnClickListener{
            priority="3"
            binding.green.setImageResource(R.drawable.save_24)
            binding.red.setImageResource(0)
            binding.yellow.setImageResource(0)
        }

        binding.savenotes.setOnClickListener{
            createnotes(it)
        }

        return binding.root
    }

    private fun createnotes(it: View?) {
        val title=binding.title.text.toString()
        val note=binding.note.text.toString()
        val d=Date()
        val date:CharSequence= DateFormat.format("MMMM d,yyyy",d.time)
        val data=notes(null,title = title,notes = note,date = date.toString(),priority)
        viewModel.addnotes(data)
        Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_create_to_home2)

    }

}