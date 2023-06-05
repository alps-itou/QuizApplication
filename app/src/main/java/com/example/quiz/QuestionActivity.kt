package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import com.example.quiz.databinding.ActivityQuestionBinding

class QuestionActivity : AppCompatActivity() {

    private var TAG = "QuestionActivity"
    private lateinit var binding: ActivityQuestionBinding
    private var rightAnswer: String? = null //正解を入れる
    private var rightAnswerCount = 0        //正解数をカウントする
    private var quizCount = 1               //何問目を出題しているかカウントする
    private val QUIZ_COUNT = 5
    private lateinit var timer: CountDownTimer
    private var isTimerRunning = false

    private val quizData = mutableListOf(
        mutableListOf("テニスの点数の数え方には何が関係しているか？",
            "60進法", "元々15点が1セットだった", "40進法", "元々40点マッチだった"),
        mutableListOf("スポーツの語源はどこの言葉？", "ラテン語", "英語", "イタリア語", "フランス語"),
        mutableListOf("高地トレーニングを行うことで得られる造血因子で、赤血球を増加させたりヘモグロビンの濃度を高めることで知られる物質をなんというか？",
            "エリスロポリチン", "アドレナリン", "クレアチン", "ミオグロビン"),
        mutableListOf("日本のスポーツチームは侍ジャパンやなでしこジャパンのように○〇ジャパンと呼ばれることがありますが、「彗星ジャパン」は何の競技のチームに呼ばれているでしょうか？",
            "ハンドボール", "ボブスレー", "競泳", "ホッケー"),
        mutableListOf("球界で1番良いバッターは、大谷翔平選手ですが、いいバッターは誰でしょうか。", "井端弘和", "イチロー", "坂本勇人", "松井秀喜"),
        mutableListOf("日本で生まれたスポーツは次のうちどれでしょう？", "ソフトテニス", "ソフトボール", "硬式テニス", "野球"),
        mutableListOf("「野球」の名づけ親は？", "中馬庚", "正岡子規", "加藤弘之", "伊藤博文"),
        mutableListOf("スケボーで前か後ろのウィールでバランスを取りながら進むトリックをなんという", "マニュアル", "パワースライド", "ショービット", "ハイジャンプ"),
        mutableListOf("福岡県福岡市出身の柔道家、元政治家で、オリンピックで2度、世界選手権で7度金メダルを獲得した女子選手は誰か？",
            "谷亮子", "松本薫", "猪熊柔", "伊調馨"),
        mutableListOf("ゴルフでパーより3打少なく上がることを何という？", "アルバトロス", "ターキー", "トリプル", "コンドル"),
        mutableListOf("相撲のどすこいとはどういう意味？", "力士の唄の囃子言葉", "ありがとうございます", "おやすみなさい", "かかってこい"),
        mutableListOf("競泳の泳ぎの種類は、平泳ぎ・背泳ぎ・バタフライ、あと一つは何か？", "自由形", "クロール", "飛び込み", "犬掻き"),
        mutableListOf("オリンピックのマークは5つの輪で出来ているが、何色でしょうか？", "青・黄色・黒・緑・赤", "青・黄色・紫・緑・赤", "青・オレンジ・黒・緑・赤", "茶色・黄色・黒・緑・赤"),
        mutableListOf("「ポロ」とは、何に乗ってするスポーツですか？", "馬", "象", "カバ", "キリン"),
        mutableListOf("コース、クラブ、ボール、ドライバー、バンカー・・・から連想されるスポーツは？", "ゴルフ", "マラソン", "水泳", "サッカー"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_question)

        Log.d(TAG,"onCreate(作成)")

        binding = ActivityQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        quizData.shuffle()

        showNextQuiz()
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG,"onStart(開始)")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart(再表示)")
    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG,"onResume(再開)")

    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG,"onPause(停止)")
    }

    override fun onStop(){
        super.onStop()
        Log.d(TAG,"onStop(非表示)")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG,"onDestroy(終了)")
    }


    //クイズ出題
    fun showNextQuiz() {
        //カウントラベルの更新
        binding.countLabel.text = getString(R.string.count_label, quizCount)
        //クイズ1問
        val quiz = quizData[0]

        //問題セット
        binding.questionLabel.text = quiz[0]

        //正解セット
        rightAnswer = quiz[1]

        //都道府県名削除
        quiz.removeAt(0)

        //正解と選択肢３つをシャッフル
        quiz.shuffle()

        //選択肢セット
        binding.answerBtn1.text = quiz[0]
        binding.answerBtn2.text = quiz[1]
        binding.answerBtn3.text = quiz[2]
        binding.answerBtn4.text = quiz[3]

        quizData.removeAt(0)
        Log.d(TAG, "showNextQuiz(出題)")

        startTimer()
    }
    //タイマー起動
    fun startTimer(){
        //
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val maxvalue = 5
        progressBar.max = maxvalue
        progressBar.progress = maxvalue
        progressBar.setProgress(maxvalue)
        timer = object : CountDownTimer(5000, 1000)
        {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (millisUntilFinished / 1000).toInt()
                progressBar.progress = progress + 1
                val message = if(progress == 0) "まだ0" else "まだ${millisUntilFinished}"
                Log.d(TAG, message)
            }

            override fun onFinish() {
                progressBar.progress = 0
                // 5秒経過後に次の問題に移る処理を実装する
                if(!isTimerRunning){
                    return
                }
                val message = if(quizCount < QUIZ_COUNT) "次の問題へ" else "終了"  //最後の問題だけダイアログ表示は終了
                AlertDialog.Builder(this@QuestionActivity)
                    .setTitle("時間切れ")
                    .setMessage(message)
                    .setPositiveButton("OK"){
                            dialogInterface, i -> checkQuizCount()
                    }
                    .setCancelable(false)
                    .show()
                Log.d(TAG, "５秒経過")
            }
        }
        isTimerRunning = true
        timer.start()
    }

    //タイマーストップ
    fun cancelTimer() {
        if (::timer.isInitialized) {
            timer.cancel()
            isTimerRunning = false
            Log.d(TAG, "初期化")
        }
    }

    //解答ボタンが押されたら呼ばれる
    fun checkAnswer(view: View) {
//        if (binding.progressBar.progress == 0) {
//            return
//        }

        val answerBtn: Button = findViewById(view.id)
        val btnText = answerBtn.text.toString()

        //ダイアログのタイトル作成
        val alertTitle: String
        if(btnText == rightAnswer){
            alertTitle = "正解！"
            rightAnswerCount++
        }else{
            alertTitle = "不正解..."
        }

        //ダイアログ作成
        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("答え : $rightAnswer")
            .setPositiveButton("OK"){
                    dialogInterface, i -> checkQuizCount()
            }
            .setCancelable(false)
            .show()
        Log.d(TAG,"checkAnswer(解答)")
        cancelTimer()
    }

    //出題数チェック
    fun checkQuizCount(){
        if(quizCount == QUIZ_COUNT){
            //結果画面を表示
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
            startActivity(intent)

        }else{
            quizCount++
            showNextQuiz()
        }

        Log.d(TAG,"checkQuizCount(出題数)")
    }
}

