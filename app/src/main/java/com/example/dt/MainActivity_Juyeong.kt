package com.example.dt

import androidx.appcompat.app.AppCompatActivity
import android.app.TimePickerDialog
import android.os.Bundle
import android.os.Build
import android.widget.Button
import android.content.Intent
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import android.media.MediaPlayer


class MainActivity_Juyeong : AppCompatActivity() {
    // SharedPreferences: 클래스 간에 공유되는 변수 저장
    private lateinit var sharedPreferences: SharedPreferences
    // MediaPlayer 객체 생성
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_juyeong)
        
        // sharedPreferences 객체 선언
        sharedPreferences = getSharedPreferences("com.example.dt", Context.MODE_PRIVATE)
        
        // button 변수 선언
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
            // login 기능
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        time.setOnClickListener {
            // 휴대폰 사용 시간 제어
            // 시작 시간 선택
            val startHour = sharedPreferences.getInt("startHour", 0)
            val startMinute = sharedPreferences.getInt("startMinute", 0)
            val timePickerDialogStart = TimePickerDialog(this, { _, hourOfDay, minute ->
                sharedPreferences.edit().putInt("startHour", hourOfDay).putInt("startMinute", minute).apply()

                // 종료 시간 선택
                val endHour = sharedPreferences.getInt("endHour", 0)
                val endMinute = sharedPreferences.getInt("endMinute", 0)
                val timePickerDialogEnd = TimePickerDialog(this, { _, endHourOfDay, endMinute ->
                    sharedPreferences.edit().putInt("endHour", endHourOfDay).putInt("endMinute", endMinute).apply()
                }, endHour, endMinute, true)

                timePickerDialogEnd.setTitle("종료 시간 선택")
                timePickerDialogEnd.show()

            }, startHour, startMinute, true)

            timePickerDialogStart.setTitle("시작 시간 선택")
            timePickerDialogStart.show()
        }

        use_time.setOnClickListener {
            // 휴대폰 사용 시간 notification
            val serviceIntent = Intent(this, UseTimeService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        saying.setOnClickListener {
            // 명언 notification
            startService(Intent(this, SayingService::class.java))
        }

        ad.setOnClickListener {
            // 광고 notification
            // val intent = Intent(this, AdService::class.java)
            // startService(intent)
        }

        bluelight.setOnClickListener {
            // 블루라이트 차단 실행
            startActivity(Intent(Settings.ACTION_DISPLAY_SETTINGS))
        }

        asmr.setOnClickListener {
            // ASMR 자동 재생
            val serviceIntent = Intent(this, ASMRService::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }
        }

        block.setOnClickListener {
            // 휴대폰 사용 시간 제한
        }

        message.setOnClickListener {
            // 이상한 메시지 전송
        }

        donation.setOnClickListener {
            // 자동으로 기부
        }

        present.setOnClickListener {
            // 자동 선물
        }
    }
}
