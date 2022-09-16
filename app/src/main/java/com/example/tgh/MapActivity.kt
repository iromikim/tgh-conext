package com.example.tgh

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MapActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.map)

        Firebase.firestore.collection("UserData")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Design", document.data.get("tag").toString())
                    Log.d("Programming", document.data.get("tag").toString())
                    Log.d("Cycling",  document.data.get("tag").toString() )
                    Log.d("Music",  document.data.get("tag").toString() )
                    Log.d("Physics",  document.data.get("tag").toString() )
                }
            }

        //firestoreとの対応が必要, bubble1? bubble2?
        val btnStart: AppCompatImageButton = findViewById(R.id.bubble1)
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
