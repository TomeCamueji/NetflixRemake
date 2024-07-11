package com.example.netflixremake

import android.annotation.SuppressLint
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixremake.model.Movie
import com.example.netflixremake.model.sectionAdapter

class MovieActivity : AppCompatActivity() {
    private lateinit var toolbar:Toolbar
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_movie)

       val txtTitle:TextView = findViewById(R.id.txt_title)
        val txtDesc:TextView = findViewById(R.id.txt_destrition)
        val txtCast:TextView = findViewById(R.id.txt_cast)

        val rv:RecyclerView = findViewById(R.id.movie_rv_similar)
        val movies = mutableListOf<Movie>()
        rv.layoutManager = GridLayoutManager(this,3)
        rv.adapter = MovAdapter(movies,R.layout.category2_item)

        txtTitle.text = getString(R.string.title)
        txtDesc.text = getString(R.string.descrition)
        txtCast.text = getString(R.string.cast, "Robert Pattinson,Zoë Kravitz ,Paul Dano," +
                "Jeffrey Wright, John Turturro,Peter Sarsgaard,Andy Serkis,Colin Farrell ")

        toolbar = findViewById(R.id.movie_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null
        val layerDrawable:LayerDrawable = ContextCompat.getDrawable(this,R.drawable.sombras) as LayerDrawable
        val movieCover = ContextCompat.getDrawable(this,R.drawable.movie_4)
        layerDrawable.setDrawableByLayerId(R.id.cover_drawable,movieCover)
        val coverImg:ImageView = findViewById(R.id.movie_img)
        coverImg.setImageDrawable(layerDrawable)
    }
}