package com.example.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    private var begin: Int = 0
    private var end: Int = 100
    private var guess: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        begin = intent.getIntExtra("begin", 0)
        end = intent.getIntExtra("end", 100)
        Log.d("mytag", "begin = $begin")
        Log.d("mytag", "end = $end")
        val tvQuestion = findViewById<TextView>(R.id.question)
        guess = (begin + end) / 2
        tvQuestion.text = "Ваше число больше, чем $guess?"
    }

    fun onYesNoClick(view: View) {
        val tvQuestion = findViewById<TextView>(R.id.question)

        if (end - begin <= 1) {
            tvQuestion.text = "Ваше число $begin?"
            if (view.id == R.id.yes) {
                tvQuestion.text = "Ура! Победа!"
            }
            return
        }


        when (view.id) {
            R.id.yes -> {
                Log.d("mytag", "yes")
                begin = guess + 1
            }
            R.id.no -> {
                Log.d("mytag", "no")
                end = guess
            }
        }

        guess = (begin + end) / 2
        tvQuestion.text = if (end - begin <= 1) {
            "Ваше число $begin?"
        } else {
            "Ваше число больше, чем $guess?"
        }
    }
}
