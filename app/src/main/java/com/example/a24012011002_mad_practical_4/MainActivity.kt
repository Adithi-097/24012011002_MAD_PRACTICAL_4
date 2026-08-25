package com.example.a24012011002_mad_practical_4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var textAlarm: TextView
    lateinit var cardSetAlarm: MaterialCardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textAlarm = findViewById<TextView>(R.id.txtAlarmTime)
        cardSetAlarm = findViewById(R.id.card1)
        cardSetAlarm.visibility = View.GONE

        findViewById<Button>(R.id.button).setOnClickListener {
            showTimeDialog()
        }

        findViewById<Button>(R.id.button1).setOnClickListener {
            cardSetAlarm.visibility = View.GONE
            setAlarm(0, AlarmBroadcastReceiver.STOP_VAL)

        }
    }

    private fun showTimeDialog() {
        val cldr: Calendar = Calendar.getInstance()
        val h: Int = cldr.get(Calendar.HOUR_OF_DAY)
        val m: Int = cldr.get(Calendar.MINUTE)
        val picker = TimePickerDialog(
            this, { tp, sHour, sMinute -> sendDialogDataToActivity(sHour, sMinute) }, h, m, false
        )
        picker.show()

    }

    private fun sendDialogDataToActivity(hour: Int, minute: Int){
        val alarmCalendar = Calendar.getInstance()
        val year : Int = alarmCalendar.get(Calendar.YEAR)
        val month : Int = alarmCalendar.get(Calendar.MONTH)
        val day : Int = alarmCalendar.get(Calendar.DATE)

        alarmCalendar.set(year, month, day, hour, minute, 0)

        textAlarm.text= SimpleDateFormat("hh:mm ss a").format(alarmCalendar.time)

        cardSetAlarm.visibility = View.VISIBLE

        setAlarm(alarmCalendar.timeInMillis, AlarmBroadcastReceiver.START_VAL)
    }


    private fun setAlarm(millisTime: Long, value: String) {

        val intent = Intent(this, AlarmBroadcastReceiver::class.java)
        intent.putExtra(AlarmBroadcastReceiver.SERVICE_KEY, value)

        val pendingIntent = PendingIntent.getBroadcast(this, 123, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager

        if (value == AlarmBroadcastReceiver.START_VAL) {

            alarmManager.set(AlarmManager.RTC_WAKEUP, millisTime, pendingIntent)

        }
        else if (value == AlarmBroadcastReceiver.STOP_VAL) {

            alarmManager.cancel(pendingIntent)
        }


    }
}