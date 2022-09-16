package com.example.tgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this, FirebaseOptions.Builder()
            .setApplicationId("1:711191469999:android:f8ce87dd9830ec1f33595a")
            .setApiKey("AIzaSyAF5I5cm0XMYjz8mvSPWjMbdK-VsEsTlos")
            .setProjectId("team-31-fe45d")
            .build())
        val btnStart: Button = findViewById(R.id.post)
        btnStart.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)


        }
    }
}