package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CanclechallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canclechallenge)
        // var declare
        val yes: Button = findViewById(R.id.button1)
        val no: Button = findViewById(R.id.button2)

        yes.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        no.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
    }
}