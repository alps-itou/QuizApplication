package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import com.example.quiz.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private var TAG = "MainActivity"
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        var binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        Log.d(TAG,"onCreate(Main)")

    }
    override fun onStart(){
        super.onStart()
        Log.d(TAG,"onStart(Main)")

    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG,"onResume(Main)")
        val button2 = findViewById<Button>(R.id.button_sports)
        button2.setOnClickListener {
            val intent2 = Intent(this, QuestionActivity::class.java)
            startActivity(intent2)
        }
    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG,"onPause(Main)")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG,"onStop(Main)")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy(Main)")
    }
}
