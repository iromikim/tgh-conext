package com.example.tgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapCloseupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_closeup)

        val btnBack : Button = findViewById(R.id.button2)
        //戻るボタン（アクティビティの終了）
        btnBack.setOnClickListener {
            finish()
        }

        val btnToPost: Button =findViewById(R.id.post)

        btnToPost.setOnClickListener {
        val intent = Intent(this,SeePostActivity::class.java)
        startActivity(intent)
        }

    }
}