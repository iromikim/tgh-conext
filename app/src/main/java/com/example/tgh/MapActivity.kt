package com.example.tgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)

        //TODO val btnStart: Button =findViewById(R.id.btnStart)

        //TODO btnStart.setOnClickListener {
            val intent = Intent(this,MapCloseupActivity::class.java)
            startActivity(intent)
    }
}