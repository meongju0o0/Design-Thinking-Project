package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SetmessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setmessage)
        // var declare
        val apply: Button = findViewById(R.id.button)

        apply.setOnClickListener {
            val intent = Intent(this, SetdutationActivity::class.java)
            startActivity(intent)
        }
    }
}