package com.example.tgh

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.activity.result.contract.ActivityResultContracts
import com.example.tgh.databinding.ActivityMainBinding
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class PostActivity : AppCompatActivity() {
    private lateinit var container: LinearLayout

    // キーボード表示を制御するためのオブジェクト
    private lateinit var inputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post)

        // 背景のレイアウトを取得
        container = findViewById(R.id.container)

        // InputMethodManagerを取得
        inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        val btnToPost: Button = findViewById(R.id.post)
        btnToPost.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }

        val btnToReturn: Button = findViewById(R.id.buttonforreturn)
        btnToReturn.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
        }


        //ボタンを押したとき
        val btnStart: Button = findViewById(R.id.post)
        btnStart.setOnClickListener {
           val user=UserData(id="testuser", contents ="test",tag="design")
            //setvalueを使いたい
            Firebase.firestore.collection("UserData")
                .add(user)
                .addOnSuccessListener { Log.d("TAG", "DocumentSnapshot successfully updated!") }
                .addOnFailureListener { e -> Log.w("TAG", "Error updating document", e) }

            //database.child("UserData").child(userId).setValue(UserData)


        }

    }




    // 画面タップ時に呼ばれる
    override fun onTouchEvent(event: MotionEvent): Boolean {

        // キーボードを隠す
        inputMethodManager.hideSoftInputFromWindow(
            container.getWindowToken(),
            InputMethodManager.HIDE_NOT_ALWAYS
        )

        // 背景にフォーカスを移す
        container.requestFocus()

        return false
    }
}