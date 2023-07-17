package com.kamel.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCountriesData()
    }

    private fun setupCountriesData() {
            val gson = Gson()
            val jsonString = readJsonFile("countries.json")
            val countriesList = gson.fromJson(jsonString, Countries::class.java).countries
            QuestionGenerator.allAvailableAnswers.addAll(countriesList.map { country -> country.name })

    }

    private fun readJsonFile(fileName: String): String {
        val inputStream = this.assets.open(fileName)
        return inputStream.bufferedReader().use { it.readText() }
    }

    data class Country(val name: String)
    data class Countries(val countries: List<Country>)
}