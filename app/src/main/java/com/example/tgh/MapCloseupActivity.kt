package com.example.tgh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.widget.AppCompatImageButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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

        Firebase.firestore.collection("UserData")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("Post", document.data.get("contents").toString())
                    Log.d("Post", document.data.get("contents").toString())
                    Log.d("Post",  document.data.get("contents").toString() )
                    Log.d("Post",  document.data.get("contents").toString() )
                    Log.d("Post",  document.data.get("contents").toString() )
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