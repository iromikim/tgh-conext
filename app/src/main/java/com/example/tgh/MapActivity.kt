package com.example.tgh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)


        //firestoreとの対応が必要, bubble1? bubble2?
        val btnStart: Button = findViewById(R.id.bubble1)
        btnStart.setOnClickListener {
            val intent = Intent(this, MapCloseupActivity::class.java)
            startActivity(intent)
        }

        val btnPost: Button = findViewById(R.id.post)
        btnPost.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }
    }
}
