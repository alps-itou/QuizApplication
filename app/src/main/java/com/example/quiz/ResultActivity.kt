package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.quiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private var TAG = "ResultActivity"
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_result)
        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //正解数を取得
        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        Log.d(TAG, "結果")
        //TextViewに表示
        binding.resultLabel.text = getString(R.string.result_score, score)

        val view1 = findViewById<ImageView>(R.id.imageViewResult)
        val view2 = findViewById<TextView>(R.id.resultLabel)
        val view3 = findViewById<ImageView>(R.id.imageViewAll)
        val view3_1 = findViewById<ImageView>(R.id.imageView1)
        val view3_2 = findViewById<ImageView>(R.id.imageView2)
        val view3_3 = findViewById<ImageView>(R.id.imageView3)
        val view3_4 = findViewById<ImageView>(R.id.imageView4)
        val view3_0 = findViewById<ImageView>(R.id.imageView0)
        val view4 = findViewById<Button>(R.id.tryAgainBtn)
        val view4_1 = findViewById<Button>(R.id.endBtn)

        val handler = Handler()
        val delay = 1000L
        val delay_stamp = 2000L
        val delay_button = 3000L
        val runnable1 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view1.startAnimation(fadeInAnimation)
        }

        val runnable2 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view2.startAnimation(fadeInAnimation)
        }

        val runnable3 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view3.startAnimation(fadeInAnimation)
        }

        val runnable3_1 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view3_1.startAnimation(fadeInAnimation)
        }

        val runnable3_2 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view3_2.startAnimation(fadeInAnimation)
        }

        val runnable3_3 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view3_3.startAnimation(fadeInAnimation)
        }

        val runnable3_4 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view3_4.startAnimation(fadeInAnimation)
        }

        val runnable3_0 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view3_0.startAnimation(fadeInAnimation)
        }

        val runnable4 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view4.startAnimation(fadeInAnimation)
        }

        val runnable4_1 = Runnable{
            val fadeInAnimation = AlphaAnimation(0f, 1f)
            fadeInAnimation.duration = 1000
            fadeInAnimation.fillAfter = true
            view4_1.startAnimation(fadeInAnimation)
        }

        handler.postDelayed(runnable1, delay)
        handler.postDelayed(runnable2, delay)

        when (score) {
            5 -> {
//                view3.setImageResource(R.drawable.img_result_5)
//                view3.startAnimation(AlphaAnimation(0f,1f).apply{
//                    duration = 1000
//                    fillAfter = true
//                })
                handler.postDelayed(runnable3, delay_stamp)
                handler.postDelayed(runnable4_1, delay_button)
            }
            4 -> {
//                view3_4.setImageResource(R.drawable.img_result_4)
//                view3_4.startAnimation(AlphaAnimation(0f,1f).apply{
//                    duration = 1000
//                    fillAfter = true
//                })
                handler.postDelayed(runnable3_4, delay_stamp)
               handler.postDelayed(runnable4, delay_button)
            }

            3 -> {
//                view3_3.setImageResource(R.drawable.img_result_3)
//                view3_3.startAnimation(AlphaAnimation(0f,1f).apply{
//                    duration = 1000
//                    fillAfter = true
//                })
                handler.postDelayed(runnable3_3, delay_stamp)
               handler.postDelayed(runnable4, delay_button)
            }

            2 -> {
//                view3_2.setImageResource(R.drawable.img_result_2)
//                view3_2.startAnimation(AlphaAnimation(0f,1f).apply{
//                    duration = 1000
//                    fillAfter = true
//                })
                handler.postDelayed(runnable3_2, delay_stamp)
                handler.postDelayed(runnable4, delay_button)
            }

            1 -> {
//                view3_1.setImageResource(R.drawable.img_result_1)
//                view3_1.startAnimation(AlphaAnimation(0f,1f).apply{
//                    duration = 1000
//                    fillAfter = true
//                })
                handler.postDelayed(runnable3_1, delay_stamp)
                handler.postDelayed(runnable4, delay_button)
            }

            else -> {
//                view3_0.setImageResource(R.drawable.img_result_0)
//                view3_0.startAnimation(AlphaAnimation(0f,1f).apply{
//                    duration = 1000
//                    fillAfter = true
//                })
                handler.postDelayed(runnable3_0, delay_stamp)
                handler.postDelayed(runnable4, delay_button)
            }
        }

        binding.endBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.tryAgainBtn.setOnClickListener {
            startActivity(Intent(this, QuestionActivity::class.java))
        }
        Log.d(TAG, "onCreate(Result)")
    }



    override fun onStart(){
        super.onStart()
        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
//        when (score) {
//            5 -> {
//                binding.imageViewAll.visibility = View.VISIBLE
//                binding.endBtn.visibility = View.VISIBLE
//                binding.tryAgainBtn.visibility = View.INVISIBLE
//            }
//            4 -> binding.imageView4.visibility = View.VISIBLE
//
//            3 -> binding.imageView3.visibility = View.VISIBLE
//
//            2 -> binding.imageView2.visibility = View.VISIBLE
//
//            1 -> binding.imageView1.visibility = View.VISIBLE
//
//            else -> binding.imageView0.visibility = View.VISIBLE
//        }
        Log.d(TAG,"onStart(Result)")
    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG,"onResume(Result)")
    }
    override fun onPause(){
        super.onPause()
        Log.d(TAG,"onPause(Result)")
    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG,"onStop(Result)")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy(Result)")
    }
}







