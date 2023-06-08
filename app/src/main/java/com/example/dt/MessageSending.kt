package com.example.dt

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.telephony.SmsManager
import android.telephony.SubscriptionManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MessageSending(private val activity: Activity) {

    fun sendSms() {
        if (isSendSmsPermissionGranted()) {
            val subscriptionId = SubscriptionManager.getDefaultSmsSubscriptionId()
            val smsManager = SmsManager.getSmsManagerForSubscriptionId(subscriptionId)

            val phoneNumber = "+82-10-9809-9551"
            val smsBody = "I am GAY"

            smsManager.sendTextMessage(phoneNumber, null, smsBody, null, null)
        } else {
            requestSendSmsPermission()
        }
    }

    private fun isSendSmsPermissionGranted(): Boolean {
        return ContextCompat.checkSelfPermission(
            activity,
            Manifest.permission.SEND_SMS
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun requestSendSmsPermission() {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.SEND_SMS),
            0
        )
    }
}
