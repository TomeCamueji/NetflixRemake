package com.example.netflixremake

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Movie
import com.example.netflixremake.model.category

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val categories = mutableListOf<category>()
        for (j in 0 until 50){
            val movies = mutableListOf<Movie>()
            for (i in 0 until 10){
               val movie = Movie(R.drawable.mov_1)
                movies.add(movie)
            }
            val Category = category("Programas infantil $j",movies)
            categories.add(Category)
        }

        val adapter = CategoryAdapter(categories)
        val rv:RecyclerView = findViewById(R.id.rv_main)
            rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter
    }


}