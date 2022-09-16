package com.example.tgh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MapActivity : AppCompatActivity() {

    val bubbletexts get() = listOf<TextView>(
        findViewById<TextView>(R.id.bubble1text),
        findViewById<TextView>(R.id.bubble2text),
        findViewById<TextView>(R.id.bubble3text),
        findViewById<TextView>(R.id.bubble4text),
        findViewById<TextView>(R.id.bubble5text),
    )

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)

        Firebase.firestore.collection("UserData")
            .get()
            .addOnSuccessListener { result ->
                val tags = result.documents.map { it.data?.get("tag").toString() }.distinct()

                tags.forEachIndexed { index, s ->
                    if (index >= bubbletexts.size) return@forEachIndexed
                    bubbletexts[index].text = s
                }
            }

        //firestoreとの対応が必要, bubble1? bubble2?
       // val btnBubble1: AppCompatImageButton = findViewById(R.id.bubble1)

        listOf<AppCompatImageButton>(
            findViewById(R.id.bubble1),
            findViewById(R.id.bubble2),
            findViewById(R.id.bubble3),
            findViewById(R.id.bubble4),
            findViewById(R.id.bubble5),
        ).forEachIndexed { index, appCompatImageButton ->
            appCompatImageButton.setOnClickListener {
                val intent = Intent(this, MapCloseupActivity::class.java)
                intent.putExtra("bubble_tag",bubbletexts[index].text)
                startActivity(intent)
            }
        }


        val btnPost: Button = findViewById(R.id.post)
        btnPost.setOnClickListener {
            val intent = Intent(this, PostActivity::class.java)
            startActivity(intent)
        }
    }
}
