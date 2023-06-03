package com.example.dt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class AdService : Service() {
    private lateinit var notificationManager: NotificationManager
    private val channelId = "MyAdServiceChannel"
    private val adList: List<String> = listOf(
        "This is your first ad!",
        "Don't miss this second ad!",
        "Amazing offer in the third ad!",
        "Fourth ad with incredible discount!",
        "Fifth ad: Best product ever!"
    )

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        showNotification()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "My Ad Notification Channel"
            val descriptionText = "This is my own ad notification channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            channel.setSound(null, null) // Added to mute sound
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val randomAd = adList[Random.nextInt(adList.size)]
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground) // Replace with your own icon
            .setContentTitle("Ad notification")
            .setContentText(randomAd)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notificationManager.notify(3, builder.build())
        }
    }
}
