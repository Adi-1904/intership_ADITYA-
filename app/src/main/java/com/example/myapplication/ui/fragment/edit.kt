package com.example.myapplication.ui.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentEditBinding
import com.example.myapplication.model.notes
import com.example.myapplication.viewmodel.notesViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import java.util.*

class edit : Fragment() {
     val notes by navArgs<editArgs>()
    val viewModel: notesViewModel by viewModels()
    lateinit var binding:FragmentEditBinding
    var priority:String="1"
    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding= FragmentEditBinding.inflate(layoutInflater,container,false)
            binding.edittitle.setText(notes.data.title)
            binding.editnote.setText(notes.data.notes)
        when(notes.data.priority)
        {
            "1"->{
                priority="1"
                binding.red.setImageResource(R.drawable.save_24)
                binding.yellow.setImageResource(0)
                binding.green.setImageResource(0)
            }
            "2"->{
                priority="2"
                binding.yellow.setImageResource(R.drawable.save_24)
                binding.red.setImageResource(0)
                binding.green.setImageResource(0)
            }
            "3"->{
                priority="3"
                binding.green.setImageResource(R.drawable.save_24)
                binding.red.setImageResource(0)
                binding.yellow.setImageResource(0)
            }
        }
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
        binding.editsavenotes.setOnClickListener{
            updatenote(it)
        }
        binding.delete.setOnClickListener{
            val bottomsheet:BottomSheetDialog= BottomSheetDialog(requireContext(),R.style.bottomsheetstyle)
            bottomsheet.setContentView(R.layout.dialog)
            val yes=bottomsheet.findViewById<TextView>(R.id.deleteyes)
            val no=bottomsheet.findViewById<TextView>(R.id.deleteno)
            yes?.setOnClickListener{
                viewModel.deletenotes(notes.data.id!!)
                bottomsheet.dismiss()
                startActivity( Intent(requireContext(),MainActivity::class.java))
            }
            no?.setOnClickListener{
                bottomsheet.dismiss()
            }
            bottomsheet.show()
        }
        return binding.root
         }

    private fun updatenote(it: View?) {
        val title=binding.edittitle.text.toString()
        val note=binding.editnote.text.toString()
        val d= Date()
        val date:CharSequence= DateFormat.format("MMMM d,yyyy",d.time)
        val data= notes(notes.data.id,title = title,notes = note,date = date.toString(),priority)
        viewModel.updatenotes(data)
        Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        Navigation.findNavController(it!!).navigate(R.id.action_edit_to_home2)
    }

}