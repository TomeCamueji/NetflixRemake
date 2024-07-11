package com.example.netflixremake.Util

import android.util.Log
import com.example.netflixremake.model.Movie
import com.example.netflixremake.model.category
import org.json.JSONObject
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.concurrent.Executors
import javax.net.ssl.HttpsURLConnection

class CategoryTesk {

    fun execute(url: String) {
        //neste momento estamos usando a UI-Tread
        val executor = Executors.newSingleThreadExecutor()

        executor.execute {
            var urlConnection:HttpsURLConnection? = null
            var buffer:BufferedInputStream? = null
            var stream:InputStream? = null

            try {
                //nesse momento estamos utilizando a NOVA-Tread [processo Paralelo](2)
                val requestURL = URL(url) //abrir uma URL
                urlConnection = requestURL.openConnection() as HttpsURLConnection //abrir a conecção
                urlConnection.readTimeout = 2000 // tempo de leitura
                urlConnection.connectTimeout = 2000 // tempo de conecção

                val statusCode: Int = urlConnection.responseCode


                if (statusCode > 400) {
                    throw IOException("erro na comunicação com o servidor!")
                }
                //forma 1: simples e rápida
                stream = urlConnection.inputStream //sequências de bytes
//                val jsonAsString = stream.bufferedReader().use { it.readText()  }//bytes -> stream

                //forma 2: Bytes -> string
                buffer = BufferedInputStream(stream)
                val jsonAsString = toString(buffer)

                //o JSON está preparado para ser convertido em um DATA CLASS!!
                val categories = tocategories(jsonAsString)
                Log.i("teste", categories.toString())

            } catch (e: IOException) {
                Log.i("teste", e.message ?: "erro desconhecido", e)
            } finally {
              urlConnection?.disconnect()
                stream?.close()
                buffer?.close()
            }


        }
    }

    private fun tocategories(jsonAsString: String): List<category> {
        val categories = mutableListOf<category>()
        val jsonRoot = JSONObject(jsonAsString)
        val jsonCategories = jsonRoot.getJSONArray("category")
        for (i in 0 until jsonCategories.length()) {
            val jsonCategory = jsonCategories.getJSONObject(i)

            val title = jsonCategory.getString("title")
            val jsonMovies = jsonCategory.getJSONArray("movie")

            val movies = mutableListOf<Movie>()
            for (j in 0 until jsonCategories.length()) {
                val jsonMovie = jsonMovies.getJSONObject(j)
                val id = jsonMovie.getInt("id")
                val coverUrl = jsonMovie.getString("cover_url")

                movies.add(Movie(id, coverUrl))
            }

            categories.add(category(title, movies))
        }

        return categories
    }
    private fun toString(stream: InputStream): String{

    return
    }
}