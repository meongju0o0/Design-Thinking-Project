package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SetdutationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setdutation)
        // var declare
        val apply: Button = findViewById(R.id.button)

        apply.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
        }
    }
}