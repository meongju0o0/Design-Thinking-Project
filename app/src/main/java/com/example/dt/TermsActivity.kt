package com.example.dt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class TermsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms)

        // var declare
        val accept: Button = findViewById(R.id.accept)
        val check1: CheckBox = findViewById(R.id.check1)
        val check2: CheckBox = findViewById(R.id.check2)
        var cond1 = false
        var cond2 = false

        accept.setOnClickListener {//condition 둘다 1(=check)일때만 넘어가기
            if (cond1 && cond2) {
                val intent = Intent(this, InitsettingActivity::class.java)
                intent.putExtra("is_login", true) // login 됐는지 넘겨줌
                startActivity(intent)}
            else {Toast.makeText(this, "미동의한 약관이 있습니다.", Toast.LENGTH_SHORT).show()}
        }
        check1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {cond1 = true}
            else {cond1 = false}
        }
        check2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {cond2 = true}
            else {cond2 = false}
        }
    }
}