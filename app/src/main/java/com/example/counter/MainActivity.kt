package com.example.counter

import android.content.IntentSender.OnFinished
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.delay
import kotlin.concurrent.schedule
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var counterValue:TextView
    private lateinit var startCounter:Button
    private lateinit var stopCounter:Button
    val timer=MyCounter(10000000,1000)
    var countervalue:Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterValue=findViewById(R.id.txt_value)
        startCounter=findViewById(R.id.btn_start)
        startCounter.setOnClickListener {
            timer.start()
            startCounter.isEnabled=false
        }
        stopCounter=findViewById(R.id.btn_stop)
        stopCounter.setOnClickListener {
            timer.cancel()
            countervalue=0
            Timer().schedule(1000)
            {
                counterValue.text=(countervalue).toString()
            }
startCounter.isEnabled=true
        }
    }
    inner class MyCounter(milliisInFuture:Long,countDownInterval:Long):
            CountDownTimer(milliisInFuture,countDownInterval)
    {
        override fun onFinish() {

        }
        override fun onTick(millisUntilFinished:Long){
            countervalue++;
            counterValue.text=(countervalue).toString()
        }
            }
}