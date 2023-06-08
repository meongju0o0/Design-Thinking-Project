package com.example.dt

import android.app.TimePickerDialog
import android.content.Context
import android.content.SharedPreferences

class TimeSetting(private val context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("com.example.dt", Context.MODE_PRIVATE)
    }

    fun showTimePickerDialog() {
        val startHour = sharedPreferences.getInt("startHour", 0)
        val startMinute = sharedPreferences.getInt("startMinute", 0)

        val timePickerDialogStart = TimePickerDialog(context, { _, hourOfDay, minute ->
            sharedPreferences.edit()
                .putInt("startHour", hourOfDay)
                .putInt("startMinute", minute)
                .apply()

            showEndTimePickerDialog()
        }, startHour, startMinute, true)

        timePickerDialogStart.setTitle("시작 시간 선택")
        timePickerDialogStart.show()
    }

    private fun showEndTimePickerDialog() {
        val endHour = sharedPreferences.getInt("endHour", 0)
        val endMinute = sharedPreferences.getInt("endMinute", 0)

        val timePickerDialogEnd = TimePickerDialog(context, { _, endHourOfDay, endMinute ->
            sharedPreferences.edit()
                .putInt("endHour", endHourOfDay)
                .putInt("endMinute", endMinute)
                .apply()
        }, endHour, endMinute, true)

        timePickerDialogEnd.setTitle("종료 시간 선택")
        timePickerDialogEnd.show()
    }
}
