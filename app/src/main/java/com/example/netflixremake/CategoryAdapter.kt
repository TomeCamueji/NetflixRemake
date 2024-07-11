package com.example.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Movie
import com.example.netflixremake.model.category
// aqui é a lista horizontal
class CategoryAdapter(private val categories:List<category>): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder:CategoryViewHolder, position: Int) {
        val Category = categories[position]
        holder.bild(Category)
    }

    inner class CategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bild(Category:category){

            val TxtTilte:TextView = itemView.findViewById(R.id.txt_title)
            TxtTilte.setText(Category.name)

            val RvCategory:RecyclerView = itemView.findViewById(R.id.rv_category)
            RvCategory.layoutManager = LinearLayoutManager(itemView.context, RecyclerView.HORIZONTAL,false)
            RvCategory.adapter = MovAdapter(Category.movies,R.layout.move_item)
        }
    }
}

