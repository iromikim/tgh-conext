package com.example.tgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ViewpostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.viewpost)

        val btnToReturn: Button =findViewById(R.id.buttonforreturn)
        btnToReturn.setOnClickListener {
            val intent = Intent(this,MapCloseupActivity::class.java)
            startActivity(intent)
        }

    }
}