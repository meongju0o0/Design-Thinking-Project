package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.TimePicker
import android.widget.Toast

class InitsettingActivityActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_initsetting)
        // var declare
        val timePicker1 = findViewById<TimePicker>(R.id.timePicker1)
        val hour1 = timePicker1.hour
        val minute1 = timePicker1.minute
        val timePicker2 = findViewById<TimePicker>(R.id.timePicker2)
        val hour2 = timePicker2.hour
        val minute2 = timePicker2.minute

        //var declare_chckbox
        val check1: CheckBox = findViewById(R.id.check1)
        val check2: CheckBox = findViewById(R.id.check2)
        val check3: CheckBox = findViewById(R.id.check3)
        val check4: CheckBox = findViewById(R.id.check4)
        var cond1 = false
        var cond2 = false
        var cond3 = false
        var cond4 = false


        val apply: Button = findViewById(R.id.apply)
        //var is_login = intent.getBooleanExtra("is_login", false) // 로그인 굳이 보여주는데 구현해야할까?
        check1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {cond1 = true}
            else {cond1 = false}
        }
        check2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {cond2 = true}
            else {cond2 = false}
        }
        check3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {cond3 = true}
            else {cond3 = false}
        }
        check4.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {cond4 = true}
            else {cond4 = false}
        }
        //1:앱 사용 시간 표시
        //2:명언 팝업
        //3:블루라이트
        //4:ASMR

        apply.setOnClickListener {
            val intent = Intent(this, OnchallengeActivity::class.java)
            startActivity(intent)
            //여기에 4가지 기능 시간변수 넣고 적용하기
            //각각 true false 로 적용여부 결정
            //if (is_blueLight) ~~~느낌으로
        }
    }
}