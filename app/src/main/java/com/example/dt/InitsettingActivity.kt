package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast

class InitsettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initsetting)
        // var declare
        val timePicker1 = findViewById<TimePicker>(R.id.timePicker1)
        val start_hr = timePicker1.hour
        val start_min = timePicker1.minute
        val timePicker2 = findViewById<TimePicker>(R.id.timePicker2)
        val end_hr = timePicker2.hour
        val end_min = timePicker2.minute

        //var declare_chckbox
        val use_time: CheckBox = findViewById(R.id.check1) // 사용 시간
        val saying: CheckBox = findViewById(R.id.check2) // 명언 팝업
        val bluelight: CheckBox = findViewById(R.id.check3) // 블루라이트
        val asmr: CheckBox = findViewById(R.id.check4) // ASMR
        var chk_use_time = false
        var chk_saying = false
        var chk_bluelight = false
        var chk_asmr = false


        val apply: Button = findViewById(R.id.apply)

        use_time.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {chk_use_time = true}
            else {chk_use_time = false}
        }

        saying.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {chk_saying = true}
            else {chk_saying = false}
        }

        bluelight.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {chk_bluelight = true}
            else {chk_bluelight = false}
        }

        asmr.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {chk_asmr = true}
            else {chk_asmr = false}
        }

        apply.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            if (chk_use_time) {

            }
            else {

            }

            if (chk_saying) {

            }
            else {

            }

            if (chk_bluelight) {

            }
            else {

            }

            if (chk_asmr) {

            }
            else {

            }
        }
    }
}
