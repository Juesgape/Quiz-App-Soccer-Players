package com.example.quizappsoccerplayers

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Questionquiz : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questionquiz)

        val questionsList = Constants.getQuestions()
        Log.i("Questions size ", "${questionsList.size}")

    }
}
