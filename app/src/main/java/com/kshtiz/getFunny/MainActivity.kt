package com.kshtiz.getFunny

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMessage = findViewById<TextView>(R.id.textView)
        val bGenerateMessage = findViewById<Button>(R.id.button)
        val bSendMessage = findViewById<Button>(R.id.button2)

        //before making a request we need to add internet permission in manifest

        bGenerateMessage.setOnClickListener {
            loadText(tvMessage)
        }

        bSendMessage.setOnClickListener {
            sendMessage(tvMessage.text.toString())
        }


    }
    private fun loadText(tvMessage : TextView)
    {
        val queue = Volley.newRequestQueue(this)
        val url = "https://insult.mattbas.org/api/insult"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                tvMessage.text = "$response"
            },
            { tvMessage.text = "That didn't work!" })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
    private fun sendMessage(text : String)
    {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, text)
        intent.type = "text/plain"
        startActivity(intent)
    }

}