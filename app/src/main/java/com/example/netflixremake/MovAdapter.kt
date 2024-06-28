package com.example.netflixremake

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Movie

//aqui é a lista horizontal
class MovAdapter(private val movies:List<Movie>): RecyclerView.Adapter<MovAdapter.MovViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.move_item,parent,false)
        return MovViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovViewHolder, position: Int) {
        val mov = movies[position]
        holder.bild(mov)
    }

    inner class MovViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bild(mov:Movie){
            val Image:ImageView = itemView.findViewById(R.id.img_foto)
            Image.setImageResource(mov.coverUrl)
        }
    }
}

