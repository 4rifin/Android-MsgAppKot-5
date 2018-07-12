package com.smartherd.msgappkot

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener(){
            Log.i("MainActivity","Button Was Clicked !!")
            Toast.makeText(this,"Button Was Clicked !",Toast.LENGTH_SHORT).show()
        }

        btnSendMsgToNextActivity.setOnClickListener {
            /*explecit intent*/
            val message : String = etUserMessage.text.toString()
            Log.i("MainActivity ","Second Button Was Clicked: " + message)
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

            // move to view activity_second
            val intent = Intent (this,SecondActivity::class.java)

            /*send object parameter to second activity */
            intent.putExtra("user_message",message)

            startActivity(intent)
        }

        btnShareToOtherApps.setOnClickListener(){
            /*implicit intent*/
            val message : String = etUserMessage.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plan"
            startActivity(Intent.createChooser(intent, "Share To : "))
        }

        btnRecycleViewDemo.setOnClickListener {
            val intent = Intent(this,HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}
