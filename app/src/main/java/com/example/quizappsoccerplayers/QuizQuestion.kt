package com.example.quizappsoccerplayers

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestion : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int = 1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionquiz)

        //Finding elements by ID
        val tv_option_one = findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_option_three)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        btn_submit.setOnClickListener(this)


        mQuestionList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
    }

    private fun setQuestion() {
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        val question = mQuestionList!![mCurrentPosition-1]

        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = "Validar"
        } else {
            btn_submit.text = "Continuar"
        }

        //Finding elements by ID
        val tv_question = findViewById<TextView>(R.id.tv_question)
        val iv_image = findViewById<ImageView>(R.id.iv_image)
        val tv_option_one = findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_option_three)

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree

    }

    private fun defaultOptionsView() {
        //Finding elements by ID
        val tv_option_one = findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_option_three)

        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)

        //idk about this
        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_button)
        }
    }

    override fun onClick(v: View?) {

        //Finding elements by ID
        val tv_option_one = findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_option_three)
        val btn_submit = findViewById<Button>(R.id.btn_submit)

        when(v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three, 3)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    Toast.makeText(this, "Debes elegir una opción", Toast.LENGTH_SHORT).show()
                } else {

                    if(mSelectedOptionPosition != 0) {
                        mCurrentPosition++

                        when{
                            mCurrentPosition <= mQuestionList!!.size -> {
                                setQuestion()
                            } else -> {
                            Toast.makeText(this, "Haz completado el quiz!!", Toast.LENGTH_SHORT).show()
                        }
                        }
                    }else {
                        val question = mQuestionList?.get(mCurrentPosition - 1)
                        if(question!!.correctAnswer != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_button)
                        }
                        answerView(question.correctAnswer, R.drawable.correct_option_button)

                        if(mCurrentPosition == mQuestionList!!.size) {
                            btn_submit.text = "Validar"
                        } else {
                            btn_submit.text = "Siguiente"
                        }
                        mSelectedOptionPosition = 0

                    }

                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        val tv_option_one = findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two = findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three = findViewById<TextView>(R.id.tv_option_three)

        when(answer) {
            1 -> {
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R .drawable.selected_option_border)
    }

}