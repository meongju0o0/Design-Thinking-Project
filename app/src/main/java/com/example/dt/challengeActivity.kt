package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class challengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge)
        // var declare
        val speed: ImageButton = findViewById(R.id.button1)
        val message: ImageButton = findViewById(R.id.button2)
        val present: ImageButton = findViewById(R.id.button3)
        val donate: ImageButton = findViewById(R.id.button4)

        speed.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
        message.setOnClickListener {
            val intent = Intent(this, SetmessageActivity::class.java)
            startActivity(intent)
        }
        present.setOnClickListener {
            val intent = Intent(this, SetpresentActivity::class.java)
            startActivity(intent)
        }
        donate.setOnClickListener {
            val intent = Intent(this, SetdonateActivity::class.java)
            startActivity(intent)
        }
    }
}