package com.example.myapplication.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemBinding
import com.example.myapplication.model.notes
import com.example.myapplication.ui.fragment.homeDirections

class notesAdapter(val requireContext: Context,val noteslist: List<notes>) :RecyclerView.Adapter<notesAdapter.notesViewHolder>() {
    class notesViewHolder(val binding:ItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
      val data=noteslist[position]
        holder.binding.notestitle.text = data.title
        holder.binding.notes.text=data.notes
        holder.binding.date.text=data.date
        when(data.priority)
        {
            "1"->{
                holder.binding.priority.setBackgroundResource(R.drawable.reddot)
            }
            "2"->{
                holder.binding.priority.setBackgroundResource(R.drawable.yellowdot)
            }
            "3"->{
                holder.binding.priority.setBackgroundResource(R.drawable.greendot)
            }
        }
        holder.binding.root.setOnClickListener {
            val action=homeDirections.actionHome2ToEdit(data)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount()=noteslist.size
}