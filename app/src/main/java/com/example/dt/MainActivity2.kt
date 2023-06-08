package com.example.dt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity2 : AppCompatActivity() {
    // SharedPreferences: 클래스 간에 공유되는 변수 저장
    private lateinit var sharedPreferences: SharedPreferences
    // MediaPlayer 객체 생성
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var launcher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val serviceIntent = Intent(this, TouchDetectionService::class.java)
                startService(serviceIntent)
            }
        }

        // sharedPreferences 객체 선언
        sharedPreferences = getSharedPreferences("com.example.dt", Context.MODE_PRIVATE)

        // button 변수 선언
        val start_challenge: Button = findViewById(R.id.button)
        val init_setting: ImageButton = findViewById(R.id.imageButton)

        start_challenge.setOnClickListener {
            val intent = Intent(this, SocialchallengeActivity::class.java)
            startActivity(intent)
        }

        init_setting.setOnClickListener {
            val intent = Intent(this, InitsettingActivity::class.java)
            startActivity(intent)
        }
    }
}
