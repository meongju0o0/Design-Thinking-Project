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
        val apply: Button = findViewById(R.id.button)
        val apply1: Button = findViewById(R.id.button1)
        val apply2: Button = findViewById(R.id.button2)
        val apply3: Button = findViewById(R.id.button3)
        val apply4: Button = findViewById(R.id.button4)


        apply.setOnClickListener {
            val intent = Intent(this, challengeActivity::class.java)
            startActivity(intent)
        }
        apply1.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        apply2.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        apply3.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        apply4.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
    }

}