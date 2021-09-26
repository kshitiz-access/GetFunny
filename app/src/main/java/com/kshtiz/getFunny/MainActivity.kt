package com.kshtiz.getFunny

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMessage = findViewById<TextView>(R.id.textView)
        val bGenerateMessage = findViewById<Button>(R.id.button)
        val bSendMessage = findViewById<Button>(R.id.button2)
    }
}