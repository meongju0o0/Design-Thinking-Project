package com.example.dt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat

class ASMRService : Service() {
    private lateinit var notificationManager: NotificationManager
    private var mediaPlayer: MediaPlayer? = null
    private val channelId = "ASMRServiceChannel"

    override fun onCreate() {
        super.onCreate()
        notificationManager = getSystemService(NotificationManager::class.java) as NotificationManager
        createNotificationChannel()

        mediaPlayer = MediaPlayer.create(this, R.raw.temple_bowl)
        mediaPlayer?.isLooping = true
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val notificationIntent = Intent(this, MainActivity_Juyeong::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("ASMR Service")
            .setContentText("ASMR is playing...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(4, notification)
        mediaPlayer?.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.stop()
        mediaPlayer?.release()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "ASMR Service Channel"
            val descriptionText = "Channel for ASMR service notifications"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
                setSound(null, null)
            }

            notificationManager.createNotificationChannel(channel)
        }
    }

}
