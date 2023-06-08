package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class challengeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_challenge)

        val block: ImageButton = findViewById(R.id.button1)
        val message: ImageButton = findViewById(R.id.button2)
        val present: ImageButton = findViewById(R.id.button3)
        val donate: ImageButton = findViewById(R.id.button4)

        val block_touch_intent = Intent(this, BlockTouchService::class.java)

        block.setOnClickListener {
            startActivity(block_touch_intent)
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