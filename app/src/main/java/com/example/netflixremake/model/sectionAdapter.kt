package com.example.netflixremake.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.R

class sectionAdapter: RecyclerView.Adapter<sectionAdapter.sectionViewHolder>() {
    inner class sectionViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sectionViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.category2_item,parent,false)
        return sectionViewHolder(item)
    }

    override fun getItemCount(): Int {
        return 50
    }

    override fun onBindViewHolder(holder: sectionViewHolder, position: Int) {

    }
}