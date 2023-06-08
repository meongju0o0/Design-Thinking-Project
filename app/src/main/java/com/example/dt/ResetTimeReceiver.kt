package com.example.dt

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class ResetTimeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Reset the start time in the UseTimeActivity service
        if (context != null && intent != null && intent.action == Intent.ACTION_TIME_CHANGED) {
            val serviceIntent = Intent(context, UseTimeService::class.java)
            context.stopService(serviceIntent)
            context.startService(serviceIntent)
        }
    }
}
