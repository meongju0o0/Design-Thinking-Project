package com.example.dt

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast

class InitsettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initsetting)

        val timePicker1 = findViewById<TimePicker>(R.id.timePicker1)
        val start_hr = timePicker1.hour
        val start_min = timePicker1.minute
        val timePicker2 = findViewById<TimePicker>(R.id.timePicker2)
        val end_hr = timePicker2.hour
        val end_min = timePicker2.minute

        val use_time: CheckBox = findViewById(R.id.check1) // 사용 시간
        val saying: CheckBox = findViewById(R.id.check2) // 명언 팝업
        val bluelight: CheckBox = findViewById(R.id.check3) // 블루라이트
        val asmr: CheckBox = findViewById(R.id.check4) // ASMR
        var chk_use_time = false
        var chk_saying = false
        var chk_bluelight = false
        var chk_asmr = false

        val apply: Button = findViewById(R.id.apply)

        val use_time_intent = Intent(this, UseTimeService::class.java)
        val saying_intent = Intent(this, SayingService::class.java)
        val bluelight_intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
        val asmr_intent = Intent(this, ASMRService::class.java)

        use_time.setOnCheckedChangeListener { buttonView, isChecked ->
            chk_use_time = isChecked
        }

        saying.setOnCheckedChangeListener { buttonView, isChecked ->
            chk_saying = isChecked
        }

        bluelight.setOnCheckedChangeListener { buttonView, isChecked ->
            chk_bluelight = isChecked
        }

        asmr.setOnCheckedChangeListener { buttonView, isChecked ->
            chk_asmr = isChecked
        }

        apply.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            if (chk_use_time) {
                // 휴대폰 사용 시간 notification
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(use_time_intent)
                } else {
                    startService(use_time_intent)
                }
            }
            else {
                stopService(use_time_intent)
            }

            if (chk_saying) {
                startService(saying_intent)
            }
            else {
                stopService(saying_intent)
            }

            if (chk_bluelight) {
                startActivity(bluelight_intent)
            }

            if (chk_asmr) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(asmr_intent)
                } else {
                    startService(asmr_intent)
                }
            }
            else {
                stopService(asmr_intent)
            }
        }
    }
}
