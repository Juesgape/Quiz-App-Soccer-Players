package com.example.quizappsoccerplayers

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

@SuppressLint("StaticFieldLeak")
private lateinit var getName : EditText
@SuppressLint("StaticFieldLeak")
private lateinit var btnJugar : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getName = findViewById(R.id.get_name)
        btnJugar = findViewById(R.id.btnJugar)

        btnJugar.setOnClickListener {
            if (getName.text.toString().isEmpty()) {
                getName.setError("Error")
                Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_SHORT).show()

            } else {
                startActivity(Intent(this,QuizQuestion::class.java)
                    .putExtra(Constants.USER_NAME, getName.text.toString()))
                finish()
            }
        }

    }
}