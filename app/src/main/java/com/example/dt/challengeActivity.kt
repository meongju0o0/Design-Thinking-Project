package com.example.dt

import android.content.Intent
import android.content.pm.PackageManager
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
        val message_sending = MessageSending(this)
        val isActivityRunning = isActivityRunning(block_touch_intent)

        block.setOnClickListener {
            if (!isActivityRunning) {
                startService(block_touch_intent)
            }
            else {
                stopService(block_touch_intent)
            }
        }

        message.setOnClickListener {
            message_sending.sendSms()
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


    private fun isActivityRunning(intent: Intent): Boolean {
        val packageManager = packageManager
        val activities = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)
        return activities.isNotEmpty()
    }
}
