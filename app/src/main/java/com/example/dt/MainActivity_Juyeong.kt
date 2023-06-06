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
        val asmr_cancel: Button = findViewById(R.id.asmr_cancel)
        val block_cancel: Button = findViewById(R.id.block_cancel)
        val donation_cancel: Button = findViewById(R.id.donation_cancel)
        val present_cancel: Button = findViewById(R.id.present_cancel)

        val login_intent = Intent(this, LoginActivity::class.java)
        val time_setting = TimeSetting(this)
        val use_time_intent = Intent(this, UseTimeService::class.java)
        val saying_intent = Intent(this, SayingService::class.java)
        val bluelight_intent = Intent(Settings.ACTION_DISPLAY_SETTINGS)
        val asmr_intent = Intent(this, ASMRService::class.java)
        val overlayIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:" + packageName))
        val serviceIntent = Intent(this, TouchDetectionService::class.java)
        val message_sending = MessageSending(this)

        login.setOnClickListener {
            // login 기능
            startActivity(login_intent)
        }

        time.setOnClickListener {
            // 휴대폰 사용 시간 제어
            time.setOnClickListener {
                time_setting.showTimePickerDialog()
            }
        }

        use_time.setOnClickListener {
            // 휴대폰 사용 시간 notification
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(use_time_intent)
            } else {
                startService(use_time_intent)
            }
        }

        saying.setOnClickListener {
            // 명언 notification
            startService(saying_intent)
        }

        ad.setOnClickListener {
            // 광고 notification
            // val intent = Intent(this, AdService::class.java)
            // startService(intent)
        }

        bluelight.setOnClickListener {
            // 블루라이트 차단 실행
            startActivity(bluelight_intent)
        }

        asmr.setOnClickListener {
            // ASMR 자동 재생
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(asmr_intent)
            } else {
                startService(asmr_intent)
            }
        }

        block.setOnClickListener {
            // 터치 이벤트 발생 시 알림 발생
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (!Settings.canDrawOverlays(this)) {
                    launcher.launch(overlayIntent)
                } else {
                    startService(serviceIntent)
                }
            }
        }

        message.setOnClickListener {
            // 이상한 메시지 전송
            message_sending.sendSms()
        }

        donation.setOnClickListener {
            // 자동으로 기부
        }

        present.setOnClickListener {
            // 자동 선물
        }

        // 취소 버튼
        use_time_cancel.setOnClickListener {
            stopService(use_time_intent)
        }

        saying_cancel.setOnClickListener {
            stopService(saying_intent)
        }

        ad_cancel.setOnClickListener {

        }

        asmr_cancel.setOnClickListener {
            stopService(asmr_intent)
        }

        block_cancel.setOnClickListener {
            stopService(overlayIntent)
            stopService(serviceIntent)
        }

        donation_cancel.setOnClickListener {

        }

        present_cancel.setOnClickListener {

        }
    }
}
