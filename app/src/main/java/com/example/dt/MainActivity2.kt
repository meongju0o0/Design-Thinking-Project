package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        // var declare
        val apply: Button = findViewById(R.id.button)
        val setting: ImageButton = findViewById(R.id.imageButton)
        var from: Int = 1

        apply.setOnClickListener {
            val intent = Intent(this, SocialchallengeActivity::class.java)
            startActivity(intent)
        }

        setting.setOnClickListener {
            val intent = Intent(this, InitsettingActivity::class.java)
            startActivity(intent)
        }
    }
}