package com.example.exerciseprogrammingwithfriends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("zerom",10)
        startActivity(intent)

    }

}