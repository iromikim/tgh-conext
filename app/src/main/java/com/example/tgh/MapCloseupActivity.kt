package com.example.tgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MapCloseupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_closeup)

       /** val btnBack : Button = findViewById(R.id.buttonforreturn)
        //戻るボタン（アクティビティの終了）
        btnBack.setOnClickListener {
            finish()
        }
       */

       val btnToReturn: Button =findViewById(R.id.buttonforreturn)
        btnToReturn.setOnClickListener {
            val intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }

        val btnToPost: Button =findViewById(R.id.post)
        btnToPost.setOnClickListener {
        val intent = Intent(this,PostActivity::class.java)
        startActivity(intent)
        }

    }
}