package com.example.quizappsoccerplayers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultQuiz : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_quiz)

        val tv_username = findViewById<TextView>(R.id.tv_username)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        val btn_final = findViewById<Button>(R.id.btn_final)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tv_username.text = username
        tv_score.text = "Tu puntaje fue $correctAnswers de $totalQuestions"
        btn_final.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}