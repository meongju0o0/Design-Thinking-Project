package com.example.dt

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import android.widget.Button
import android.content.Intent
import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings
import android.media.MediaPlayer
import android.net.Uri
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity_Juyeong : AppCompatActivity() {
    // SharedPreferences: 클래스 간에 공유되는 변수 저장
    private lateinit var sharedPreferences: SharedPreferences
    // MediaPlayer 객체 생성
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_juyeong)
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val serviceIntent = Intent(this, TouchDetectionService::class.java)
                startService(serviceIntent)
            }
        }

        // sharedPreferences 객체 선언
        sharedPreferences = getSharedPreferences("com.example.dt", Context.MODE_PRIVATE)
        
        // button 변수 선언
        val login: Button = findViewById(R.id.login)
        val time: Button = findViewById(R.id.time)
        // challenge 시작 버튼 변수
        val use_time: Button = findViewById(R.id.use_time)
        val saying: Button = findViewById(R.id.saying)
        val ad: Button = findViewById(R.id.ad)
        val bluelight: Button = findViewById(R.id.bluelight)
        val asmr: Button = findViewById(R.id.asmr)
        val block: Button = findViewById(R.id.block)
        val message: Button = findViewById(R.id.message)
        val donation: Button = findViewById(R.id.donation)
        val present: Button = findViewById(R.id.present)
        // challenge 취소 버튼 변수
        val use_time_cancel: Button = findViewById(R.id.use_time_cancel)
        val saying_cancel: Button = findViewById(R.id.saying_cancel)
        val ad_cancel: Button = findViewById(R.id.ad_cancel)
        val bluelight_cancel: Button = findViewById(R.id.bluelight_cancel)
        val asmr_cancel: Button = findViewById(R.id.asmr_cancel)
        val block_cancel: Button = findViewById(R.id.block_cancel)
        val message_cancel: Button = findViewById(R.id.message_cancel)
        val donation_cancel: Button = findViewById(R.id.donation_cancel)
        val present_cancel: Button = findViewById(R.id.present_cancel)

        login.setOnClickListener {
            // login 기능
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        time.setOnClickListener {
            // 휴대폰 사용 시간 제어
            val TimeSetting = TimeSetting(this)
            time.setOnClickListener {
                TimeSetting.showTimePickerDialog()
            }
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
            // 터치 이벤트 발생 시 알림 발생
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    val overlayIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:" + packageName))
                    launcher.launch(overlayIntent)
                } else {
                    val serviceIntent = Intent(this, TouchDetectionService::class.java)
                    startService(serviceIntent)
                }
            }
        }

        message.setOnClickListener {
            // 이상한 메시지 전송
            val message_sending = MessageSending(this)
            message_sending.sendSms()
        }

        donation.setOnClickListener {
            // 자동으로 기부
        }

        present.setOnClickListener {
            // 자동 선물
        }

        use_time_cancel.setOnClickListener {

        }

        saying_cancel.setOnClickListener {

        }

        ad_cancel.setOnClickListener {

        }

        bluelight_cancel.setOnClickListener {

        }

        asmr_cancel.setOnClickListener {

        }

        block_cancel.setOnClickListener {

        }

        message_cancel.setOnClickListener {

        }

        donation_cancel.setOnClickListener {

        }

        present_cancel.setOnClickListener {

        }
    }
}
