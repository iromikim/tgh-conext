package com.example.tgh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MapCloseupActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map_closeup)

        Firebase.firestore.collection("UserData")
            .get()
            .addOnSuccessListener { result ->

                val contents = result.documents.map { it.data?.get("contents").toString() }
                val posttexts = listOf<TextView>(
                    findViewById<TextView>(R.id.post1text),
                    findViewById<TextView>(R.id.post2text),
                    findViewById<TextView>(R.id.post3text),
                    findViewById<TextView>(R.id.post4text),
                    findViewById<TextView>(R.id.post5text),
                )
                contents.forEachIndexed { index, s ->
                    if (index >= posttexts.size) return@forEachIndexed
                    posttexts[index].text = s
                }
            }


    val btnToReturn: Button =findViewById(R.id.buttonforreturn)
        btnToReturn.setOnClickListener {
            val intent = Intent(this,MapActivity::class.java)
            startActivity(intent)
        }

        val btnToPostView: AppCompatImageButton =findViewById(R.id.post1)
        btnToPostView.setOnClickListener {
        val intent = Intent(this,ViewpostActivity::class.java)
        startActivity(intent)
        }

    }
}