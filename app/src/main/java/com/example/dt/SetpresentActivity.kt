package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SetpresentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setpresent)
        val coffe: Button = findViewById(R.id.button4)
        val chick: Button = findViewById(R.id.button5)
        val beef: Button = findViewById(R.id.button6)

        coffe.setOnClickListener {
            val intent = Intent(this, SetdonateActivity::class.java)
            startActivity(intent)
        }
        chick.setOnClickListener {
            val intent = Intent(this, SetdonateActivity::class.java)
            startActivity(intent)
        }
        beef.setOnClickListener {
            val intent = Intent(this, SetdonateActivity::class.java)
            startActivity(intent)
        }
    }
}