package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SocialchallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_socialchallenge)
        // var declare
        val myself: Button = findViewById(R.id.button)
        val social1: Button = findViewById(R.id.button1)
        val social2: Button = findViewById(R.id.button2)
        val social3: Button = findViewById(R.id.button3)
        val social4: Button = findViewById(R.id.button4)


        myself.setOnClickListener {
            val intent = Intent(this, challengeActivity::class.java)
            startActivity(intent)
        }
        social1.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        social2.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        social3.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        social4.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
    }
}