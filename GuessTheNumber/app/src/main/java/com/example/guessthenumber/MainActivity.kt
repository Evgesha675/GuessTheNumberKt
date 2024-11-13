package com.example.guessthenumber

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

    }
    fun onGuessClick(view: View) {
        val begin = findViewById<EditText>(R.id.left).text.toString().toIntOrNull() ?: 0
        val end = findViewById<EditText>(R.id.right).text.toString().toIntOrNull() ?: 0

        val intent = Intent(this, GameActivity::class.java)
        intent.putExtra("begin", begin)
        intent.putExtra("end", end)
        startActivity(intent)
    }
}