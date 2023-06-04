package com.example.dt

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast

class TouchDetectionService : Service() {

    private lateinit var windowManager: WindowManager
    private lateinit var touchView: View

    override fun onCreate() {
        super.onCreate()
        // Window Manager 초기화
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        // 터치 이벤트를 감지할 View 생성
        touchView = ImageView(this).apply {
            // 터치 이벤트 처리
            setOnTouchListener(touchListener)
        }

        // View를 화면 상단에 그리기
        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.TOP or Gravity.START
        }
        windowManager.addView(touchView, params)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 서비스 종료 시 View 제거
        windowManager.removeView(touchView)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    @SuppressLint("ClickableViewAccessibility")
    private val touchListener = View.OnTouchListener { view, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                // 터치 다운 이벤트 처리
                showToast("터치 다운")
                return@OnTouchListener true
            }
            MotionEvent.ACTION_MOVE -> {
                // 터치 이동 이벤트 처리
                showToast("터치 이동")
                return@OnTouchListener true
            }
            MotionEvent.ACTION_UP -> {
                // 터치 업 이벤트 처리
                showToast("터치 업")
                return@OnTouchListener true
            }
            else -> {
                return@OnTouchListener false
            }
        }
    }

    private fun showToast(message: String) {
        // TODO: 터치 이벤트에 따른 작업 수행
        // 예시로 Toast 메시지를 출력하는 부분입니다.
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
