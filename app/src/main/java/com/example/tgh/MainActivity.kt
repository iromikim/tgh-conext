package com.example.tgh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tgh.data.UserData

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // バインディングクラスの変数
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // レイアウトを読み込み
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    // 12~
    // from web site for "view binding"
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Firestoreをインスタンス化
        val db = Firebase.firestore

        // ボタンを押したときの処理
        binding.addButton.setOnClickListener {

            // Taskをインスタンス化
            val task = UserData(
                title = binding.titleEditText.text.toString(),
            )

            db.collection("users")
                .add(task)
                .addOnSuccessListener { documentReference ->
                    Log.d(ADD_TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(ADD_TAG, "Error adding document", e)
                }
        }
    }
