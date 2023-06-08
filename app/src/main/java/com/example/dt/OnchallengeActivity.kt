package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ProgressBar

class OnchallengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onchallenge)
        // var declare
        val apply: ImageButton = findViewById(R.id.imageButton)
        val cancle: ProgressBar = findViewById(R.id.progressBar)

        apply.setOnClickListener {
            val intent = Intent(this, InitsettingActivityActivity2::class.java)
            startActivity(intent)
        }
        cancle.setOnClickListener {
            val intent = Intent(this, CanclechallengeActivity::class.java)
            startActivity(intent)
        }
    }
}