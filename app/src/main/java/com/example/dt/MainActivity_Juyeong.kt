package com.example.dt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity_Juyeong : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_juyeong)

        val login: Button = findViewById(R.id.login)
        val time: Button = findViewById(R.id.time)
        val use_time: Button = findViewById(R.id.use_time)
        val saying: Button = findViewById(R.id.saying)
        val ad: Button = findViewById(R.id.ad)
        val bluelight: Button = findViewById(R.id.bluelight)
        val asmr: Button = findViewById(R.id.asmr)
        val block: Button = findViewById(R.id.block)
        val message: Button = findViewById(R.id.message)
        val donation: Button = findViewById(R.id.donation)
        val present: Button = findViewById(R.id.present)

        login.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        time.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        use_time.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        saying.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        ad.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        bluelight.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        asmr.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        block.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        message.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        donation.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }

        present.setOnClickListener {
            // Button 클릭 시 수행할 작업
        }
    }
}