package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // var declare

        val kakao_login: Button = findViewById(R.id.kakao_login)
        val guest_login: Button = findViewById(R.id.guest_login)

        kakao_login.setOnClickListener {
            val intent = Intent(this, TermsActivity::class.java)
            startActivity(intent)
        }
        guest_login.setOnClickListener {
            val intent = Intent(this, InitsettingActivity::class.java)
            intent.putExtra("is_login", false) //login 했는지 넘겨줌
            startActivity(intent)
        }


    }
}
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//</LinearLayout>