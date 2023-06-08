package com.example.dt

import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.os.*
import androidx.core.app.NotificationCompat
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.TimeUnit

class UseTimeService : Service() {
    private lateinit var notificationManager: NotificationManager
    private val channelId = "UseTimeServiceChannel"
    private var startTime = 0L
    private val handler = Handler(Looper.getMainLooper())
    private val notificationId = AtomicInteger(0)

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        startTime = SystemClock.elapsedRealtime()
        startForeground()
    }

    @SuppressLint("LaunchActivityFromNotification")
    private fun startForeground() {
        val intent = Intent(this, MainActivity_Juyeong::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val id = notificationId.incrementAndGet() // get a new ID for the notification

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Time Service")
            .setContentText("Running...")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        // Handler to update the Notification every second while the service is running
        handler.post(object : Runnable {
            override fun run() {
                val elapsedMillis = SystemClock.elapsedRealtime() - startTime
                val hours = TimeUnit.MILLISECONDS.toHours(elapsedMillis)
                val minutes =
                    TimeUnit.MILLISECONDS.toMinutes(elapsedMillis) - TimeUnit.HOURS.toMinutes(hours)


                val notification = NotificationCompat.Builder(this@UseTimeService, channelId)
                    .setContentTitle("Time Service")
                    .setContentText(
                        String.format(
                            "You have been using this app for %02d:%02d",
                            hours,
                            minutes
                        )
                    )
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentIntent(pendingIntent)
                    .build()

                notificationManager.notify(id, notification)
                handler.postDelayed(this, 10000)
            }
        })
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Time Service Channel"
            val descriptionText = "Channel for time service notifications"
            val importance = NotificationManager.IMPORTANCE_LOW
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
                setSound(null, null)
            }
            // Initialize NotificationManager
            notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        // When the service is destroyed, remove callbacks from the handler.
        handler.removeCallbacksAndMessages(null)
    }

}
