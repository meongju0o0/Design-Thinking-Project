package com.example.dt

import kotlinx.coroutines.*

import android.app.Service
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.IBinder
import android.provider.Settings


class BlockTouchService : Service() {

    private lateinit var context: Context // Context 변수 추가

    override fun onCreate() {
        super.onCreate()
        context = applicationContext // Context 초기화
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val overlayIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            Uri.parse("package:" + packageName))
        val serviceIntent = Intent(this, TouchDetectionService::class.java)

        GlobalScope.launch {
            while(true) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!Settings.canDrawOverlays(this@BlockTouchService)) {
                        startActivity(overlayIntent)
                    } else {
                        startService(serviceIntent)
                    }
                }
                delay(60000)
                stopService(serviceIntent)
                delay(540000)
            }
        }
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        val serviceIntent = Intent(this, TouchDetectionService::class.java)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            stopService(serviceIntent)
        }
    }
}
