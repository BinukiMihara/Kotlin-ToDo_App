package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.todoapp.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {        //  Override the onCreate method to define what happens when the activity is created

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)        // Set the layout for this activity

        val action = supportActionBar         // Hide the action bar for a cleaner look
        action?.hide()

        try {
            // Use the Handler to post a delayed runnable task
            // This task will start the MainActivity after a 3-second delay
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
            }, 3000)
        } catch (e: Exception) {
            e.printStackTrace()       // Catch any exceptions that might occur during the delay
        }
    }
}
